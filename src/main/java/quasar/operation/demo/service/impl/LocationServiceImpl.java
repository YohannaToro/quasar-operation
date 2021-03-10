package quasar.operation.demo.service.impl;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;
import quasar.operation.demo.exception.ErrorMessage;
import quasar.operation.demo.exception.NotFoundShipPosition;
import quasar.operation.demo.model.*;
import quasar.operation.demo.repository.StaticSatelliteRepository;
import quasar.operation.demo.service.LocationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide position of ship
 * @author Yohanna Toro
 */
@Service
public class LocationServiceImpl implements LocationService {

    final
    StaticSatelliteRepository staticSatelliteRepository;

    public LocationServiceImpl(StaticSatelliteRepository staticSatelliteRepository) {
        this.staticSatelliteRepository = staticSatelliteRepository;
    }


    @Override
    public Position getLocation(SatelliteList satelliteList) throws NotFoundShipPosition{
        if (satelliteList.getSatellites()==null){
            throw  new NotFoundShipPosition(ErrorMessage.NOT_FOUND_POSITION);
        }

       boolean existsIntersection= anIntersectionExist(satelliteList.getSatellites());

          if (existsIntersection) {
            return calculatePosition(satelliteList);
        }
        else {
            throw  new NotFoundShipPosition(ErrorMessage.NOT_FOUND_POSITION);
        }
    }

    /**
     *  verify if exist and intersection between satellites
     * @param satelliteList
     * @return boolean value
     * @throws NotFoundShipPosition
     */
    private boolean anIntersectionExist(List<Satellite> satelliteList) throws NotFoundShipPosition {

        if (satelliteList.size() != 3){
           return  false;
        }

        for (int i = 0; i<satelliteList.size()-1; i++){
            String nameSatellite1 = satelliteList.get(i).getName();
            String nameSatellite2 = satelliteList.get(i+1).getName();
            Position p1 = getPositionByName(nameSatellite1);
            Position p2 = getPositionByName(nameSatellite2);

            double distance = getDistance(p1,p2);
            double radio1 = satelliteList.get(i).getDistance();
            double radio2 = satelliteList.get(i+1).getDistance();

            if(checkPointContainsAnotherPoint(distance,radio1,radio2))
                return  false;
            else if(checkDistanceBiggerThanRadius(distance,radio1,radio2))
                return  false;

        }
        return true;

    }

    /**
     * check if point contains another point so the circle never intersect
     * @param distance distance between two points
     * @param radio1 radio of circle one
     * @param radio2 radio of circle two
     * @return
     */
    private Boolean checkPointContainsAnotherPoint(double distance, double radio1, double radio2){
        return  distance > radio1+radio2;

    }

    /**
     * if the distance between two points is bigger than radius means circle dont intersect
     * @param distance distance between two points
     * @param radio1 radio of circle one
     * @param radio2 radio of circle two
     * @return
     */
    private Boolean checkDistanceBiggerThanRadius(double distance, double radio1, double radio2){
        return  distance< Math.abs(radio1-radio2);

    }


    private Double getDistance(Position point1, Position point2){
        double x1 = point1.getCoordinateX();
        double x2 = point2.getCoordinateX();
        double y1 = point1.getCoordinateY();
        double y2 = point2.getCoordinateY();
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    /**
     * calculate position of ship using trilateration algorithm
     * @param satelliteList
     * @return Position of ship
     * @throws NotFoundShipPosition
     */
    private Position calculatePosition(SatelliteList satelliteList ) throws NotFoundShipPosition {

        double[][] positions= getSatellitePositions(satelliteList.getSatellites());
        double[] distances = satelliteList.getDistances();

        NonLinearLeastSquaresSolver solver = new
                NonLinearLeastSquaresSolver(new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
        LeastSquaresOptimizer.Optimum optimum = solver.solve();

        double[] centroid = optimum.getPoint().toArray();

        return new Position(centroid[0],centroid[1]);
    }

    /**
     * this functions generate a matrix with position of satellites
     */
    private double[][] getSatellitePositions(List<Satellite> satellites) throws NotFoundShipPosition {

        double[][] positions= new double[satellites.size()][];

        for (int i=0; i<satellites.size();i++){
            Position position= getPositionByName(satellites.get(i).getName());
            double x=position.getCoordinateX();
            double y=position.getCoordinateY();
            positions[i]= new double[]{x, y};

        }

        return positions;
    }

    /**
     * return position of static satellites
     * @param name name of satellite
     * @return Position of satellite
     * @throws NotFoundShipPosition
     */
     private Position getPositionByName(String name) throws NotFoundShipPosition{

         staticSatelliteRepository.findById(name);
         if (staticSatelliteRepository.findById(name).isPresent()){
             return staticSatelliteRepository.findById(name).get().getPosition();
         }
         else {
             throw new NotFoundShipPosition(ErrorMessage.NOT_FOUND_POSITION);
         }

     }

}

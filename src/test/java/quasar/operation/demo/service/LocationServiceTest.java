package quasar.operation.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import quasar.operation.demo.exception.NotFoundShipPosition;
import quasar.operation.demo.model.Position;

import quasar.operation.demo.model.SatelliteList;
import quasar.operation.demo.util.SatelliteMock;

import static org.junit.Assert.assertEquals;




@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceTest {

    @Autowired
    LocationService locationService;

    @Test(expected = NotFoundShipPosition.class)
    public void shouldFailedSatelliteDistanceBiggerThanRadio() throws NotFoundShipPosition {
        SatelliteMock mock = new SatelliteMock();
        SatelliteList satelliteList= mock.createSatelliteList(100,"hola");

       Position position= locationService.getLocation(satelliteList);

    }

    @Test
    public void shouldCalculateShipLocation() throws NotFoundShipPosition {
        SatelliteMock mock = new SatelliteMock();
        SatelliteList satelliteList= mock.createSatelliteList(1000,"hola");

        Position position= locationService.getLocation(satelliteList);
        Position expected= new Position(-258.0876562379682,789.4722565766161);
        assertEquals(position.getCoordinateX(), expected.getCoordinateX(), 0.0);
        assertEquals(position.getCoordinateY(), expected.getCoordinateY(), 0.0);

    }

    @Test(expected = NotFoundShipPosition.class)
    public void shouldFailEmptySatelliteList() throws NotFoundShipPosition {
        SatelliteMock mock = new SatelliteMock();
        SatelliteList satelliteList= new SatelliteList();
        Position position= locationService.getLocation(satelliteList);

    }

}

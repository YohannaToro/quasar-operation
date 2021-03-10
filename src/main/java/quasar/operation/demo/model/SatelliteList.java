package quasar.operation.demo.model;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Yohanna Toro
 */

@Setter
@Getter
public class SatelliteList {

    private List<Satellite> satellites;

    public double[] getDistances(){
        double[] distances= new double[satellites.size()];
        for (int i=0; i<satellites.size();i++){

            distances[i]=satellites.get(i).getDistance();
        }

        return distances;
    }

    public ArrayList<ArrayList<String>> getMessages(){

        ArrayList<ArrayList<String>> messages= new ArrayList<>();
        for (Satellite satellite : satellites) {
            messages.add(satellite.getMessage());
        }
        return  messages;
    }
}

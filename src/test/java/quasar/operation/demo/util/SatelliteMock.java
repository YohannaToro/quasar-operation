package quasar.operation.demo.util;

import lombok.NoArgsConstructor;
import quasar.operation.demo.model.Satellite;
import quasar.operation.demo.model.SatelliteList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@NoArgsConstructor
public class SatelliteMock {

    List<String> names =  Arrays.asList("Sato", "Kenobi", "Skywalker");

   public  SatelliteList createSatelliteList(double distance, String message){
       List<Satellite> satellites =new ArrayList<>();
        SatelliteList satelliteList= new SatelliteList();
        satelliteList.setSatellites(satellites);

        ArrayList<String> messages= new ArrayList<>();
        for (int i =0; i<3;i++){
            if (!message.equals("")) {
                messages.add(message);
            }
            satellites.add(new Satellite(names.get(i),distance,messages));

        }
        satelliteList.setSatellites(satellites);
        return satelliteList;
    }
}

package quasar.operation.demo.service.impl;

import org.springframework.stereotype.Service;
import quasar.operation.demo.exception.ErrorMessage;
import quasar.operation.demo.exception.NotFoundShipMessage;

import quasar.operation.demo.model.Satellite;
import quasar.operation.demo.model.SatelliteList;
import quasar.operation.demo.service.MessageService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this service find the message provide by the ship
 * @author Yohanna Toro
 */
@Service
public class MessageServiceImpl implements MessageService {


    @Override
    public String getMessage(SatelliteList satelliteList) throws NotFoundShipMessage {

        ArrayList<String> message  = calculateMessage(satelliteList);

       if (message.size()==0) throw  new NotFoundShipMessage(ErrorMessage.NOT_FOUND_MESSAGE);

        return getFullMessage(message);
    }



    private ArrayList<String> calculateMessage(SatelliteList satelliteList){

        ArrayList<ArrayList<String>> satellites= satelliteList.getMessages();
         ArrayList<String> messages= new ArrayList<>();

        for (ArrayList<String> satellite : satellites) {
            for (String s : satellite) {
                if (!s.equals("") && !messages.contains(s)) {
                    messages.add(s);
                }
            }
        }
        return messages;

    }

    private String getFullMessage(ArrayList<String> message){

        return String.join(" ", message);
    }



}

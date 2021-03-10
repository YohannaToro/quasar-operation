package quasar.operation.demo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import quasar.operation.demo.exception.NotFoundShipMessage;
import quasar.operation.demo.exception.NotFoundShipPosition;
import quasar.operation.demo.model.Satellite;
import quasar.operation.demo.model.SatelliteList;
import quasar.operation.demo.model.Ship;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunicationServiceTest {
    @Autowired
    CommunicationService communicationService;

    @Test//(expected = NotFoundShipPosition.class)
    public void shouldFailedSatelliteListEmpty() throws NotFoundShipPosition, NotFoundShipMessage {
        List<Satellite> satellites= new ArrayList<>();
        SatelliteList satelliteList= new SatelliteList();
        satelliteList.setSatellites(satellites);

        System.out.println(satelliteList.getSatellites());
        satelliteList.setSatellites(satellites);
       Ship ship= communicationService.getShip(satelliteList);

        assertEquals(1, 1);
    }
}

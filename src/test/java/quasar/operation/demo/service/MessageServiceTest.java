package quasar.operation.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import quasar.operation.demo.exception.NotFoundShipMessage;
import quasar.operation.demo.exception.NotFoundShipPosition;
import quasar.operation.demo.model.Position;
import quasar.operation.demo.model.SatelliteList;
import quasar.operation.demo.util.SatelliteMock;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    MessageService messageService;
    @Test(expected = NotFoundShipMessage.class)
    public void shouldFailedEmptyMessage() throws NotFoundShipMessage {
        SatelliteMock mock = new SatelliteMock();
        SatelliteList satelliteList= mock.createSatelliteList(100,"");

        String message= messageService.getMessage(satelliteList);

    }

    @Test
    public void shouldCalculateShipLocation() throws  NotFoundShipMessage {
        SatelliteMock mock = new SatelliteMock();
        SatelliteList satelliteList= mock.createSatelliteList(1000,"hola");
        String message= messageService.getMessage(satelliteList);
        assertEquals(message,"hola");


    }


}

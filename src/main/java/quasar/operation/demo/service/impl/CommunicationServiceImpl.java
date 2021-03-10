package quasar.operation.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quasar.operation.demo.exception.NotFoundShipMessage;
import quasar.operation.demo.exception.NotFoundShipPosition;
import quasar.operation.demo.model.Position;
import quasar.operation.demo.model.Satellite;
import quasar.operation.demo.model.SatelliteList;
import quasar.operation.demo.model.Ship;

import quasar.operation.demo.repository.SatelliteRepository;
import quasar.operation.demo.service.CommunicationService;
import quasar.operation.demo.service.LocationService;
import quasar.operation.demo.service.MessageService;

/**
 * this service provide information about a ship
 * @author Yohanna Toro
 */
@Service
public class CommunicationServiceImpl implements CommunicationService {


    final
    SatelliteRepository satelliteRepository;

    final
    LocationService locationService;

    final
    MessageService messageService;

    public CommunicationServiceImpl(SatelliteRepository satelliteRepository, LocationService locationService, MessageService messageService) {
        this.satelliteRepository = satelliteRepository;
        this.locationService = locationService;
        this.messageService = messageService;
    }


    @Override
    public Ship getShip(SatelliteList satelliteList)throws NotFoundShipPosition, NotFoundShipMessage {
        Position position = locationService.getLocation(satelliteList);
        String message= messageService.getMessage(satelliteList);
        return new Ship(message,position);
    }


    @Override
    public Ship getShip() throws NotFoundShipPosition, NotFoundShipMessage {
        SatelliteList satelliteList= new SatelliteList();
        satelliteList.setSatellites(satelliteRepository.findAll());
        Position position = locationService.getLocation(satelliteList);
        String message= messageService.getMessage(satelliteList);
        return new Ship(message,position);
    }

}

package quasar.operation.demo.service;

import quasar.operation.demo.exception.NotFoundShipMessage;
import quasar.operation.demo.exception.NotFoundShipPosition;
import quasar.operation.demo.model.Satellite;
import quasar.operation.demo.model.SatelliteList;
import quasar.operation.demo.model.Ship;


public interface CommunicationService {

    Ship getShip(SatelliteList satelliteList) throws NotFoundShipPosition, NotFoundShipMessage;

    Ship getShip() throws NotFoundShipPosition, NotFoundShipMessage;
}

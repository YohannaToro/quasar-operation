package quasar.operation.demo.service;

import quasar.operation.demo.exception.NotFoundShipMessage;
import quasar.operation.demo.model.SatelliteList;


public interface MessageService {

     String getMessage(SatelliteList satelliteList) throws  NotFoundShipMessage;

}

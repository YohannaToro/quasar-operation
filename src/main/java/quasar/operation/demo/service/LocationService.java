package quasar.operation.demo.service;

import quasar.operation.demo.exception.NotFoundShipPosition;
import quasar.operation.demo.model.Position;
import quasar.operation.demo.model.SatelliteList;

public interface LocationService {

     Position getLocation(SatelliteList satelliteList) throws NotFoundShipPosition;

}

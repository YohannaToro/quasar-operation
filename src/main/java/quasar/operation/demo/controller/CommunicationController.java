package quasar.operation.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quasar.operation.demo.exception.NotFoundShipMessage;
import quasar.operation.demo.exception.NotFoundShipPosition;
import quasar.operation.demo.model.*;
import quasar.operation.demo.repository.SatelliteRepository;
import quasar.operation.demo.service.CommunicationService;


/**
 * This class provide information about position of ship
 * @author Yohanna Toro
 */
@RestController
@RequestMapping("/topsecret")
public class CommunicationController {

    final CommunicationService communicationService;

    final
    SatelliteRepository satelliteRepository;

    public CommunicationController(CommunicationService communicationService, SatelliteRepository satelliteRepository) {
        this.communicationService = communicationService;
        this.satelliteRepository = satelliteRepository;
    }

    @PostMapping
    public ResponseEntity<Ship> postListSatellite(@RequestBody SatelliteList satellites) throws NotFoundShipPosition, NotFoundShipMessage {

        return new ResponseEntity<>(communicationService.getShip(satellites), HttpStatus.OK);
    }


    @PostMapping("/{satellite_name}")
    public void postSatellite(@RequestBody Satellite satellite,@PathVariable String satellite_name){
        System.out.println(satellite.getDistance());

        satellite.setName(satellite_name);
        satelliteRepository.save(satellite);

    }

    @GetMapping
    public ResponseEntity<Ship> getShipPosition() throws NotFoundShipPosition, NotFoundShipMessage {
        return new ResponseEntity<>(communicationService.getShip(), HttpStatus.OK);
    }


}

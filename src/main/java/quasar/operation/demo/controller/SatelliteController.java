package quasar.operation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import quasar.operation.demo.model.StaticSatellite;
import quasar.operation.demo.repository.StaticSatelliteRepository;

import java.util.List;

/**
 * this class provide and create information about static satellites
 * @author Yohanna Toro
 */
@RestController
public class SatelliteController {

    private final StaticSatelliteRepository staticSatelliteRepository;

    public SatelliteController(StaticSatelliteRepository staticSatelliteRepository) {
        this.staticSatelliteRepository = staticSatelliteRepository;
    }

    @GetMapping("/satellites/static")
    public List<StaticSatellite> getStaticSatellites(){

        return staticSatelliteRepository.findAll();
    }



    @PostMapping("/satellite")
    public void saveSatellite(@RequestBody StaticSatellite satellite){

        staticSatelliteRepository.save(satellite);
    }

}

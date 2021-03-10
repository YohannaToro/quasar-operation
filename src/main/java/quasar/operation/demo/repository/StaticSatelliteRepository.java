package quasar.operation.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import quasar.operation.demo.model.StaticSatellite;

/**
 * @author Yohanna Toro
 */
public interface StaticSatelliteRepository extends MongoRepository<StaticSatellite,String> {

}


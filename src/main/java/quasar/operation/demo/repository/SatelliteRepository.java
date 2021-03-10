package quasar.operation.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import quasar.operation.demo.model.Satellite;

/**
 * @author Yohanna Toro
 */
public interface SatelliteRepository extends MongoRepository<Satellite,String> {

}

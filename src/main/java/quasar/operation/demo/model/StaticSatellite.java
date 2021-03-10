package quasar.operation.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * this class is used to represent a satellite in space
 * @author Yohanna toro
 */
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "staticSatellite")
public class StaticSatellite {

    @Id
    private String name;
    private Position position;

}

package quasar.operation.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * this class is used to represent a satellite
 * @author Yohanna Toro
 */
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Satellite")
public class Satellite {

    @Id
    private String satelliteName;

    private  double distance;

    private ArrayList<String> message;

}

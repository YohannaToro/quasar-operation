package quasar.operation.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Position represents position of any object
 * @author Yohanna Toro
 */
@AllArgsConstructor
@Getter
@Setter
public class Position {

    private double coordinateX;

    private  double coordinateY;
}

package quasar.operation.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yohanna Toro
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StatusMessageError {

    String code;

    String state;

    String errorMessage;

}

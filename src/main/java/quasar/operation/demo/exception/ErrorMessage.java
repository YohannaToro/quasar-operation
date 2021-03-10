package quasar.operation.demo.exception;

/**
 * @author Yohanna Toro
 */
public enum ErrorMessage {
    NOT_FOUND_MESSAGE("not enough information to determine the message"),
    NOT_FOUND_POSITION("there is insufficient information to determine the position");

    String message;

    ErrorMessage(String message) {
        this.message=message;
    }
}

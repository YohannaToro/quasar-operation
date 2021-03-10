package quasar.operation.demo.exception;
/**
 * @author Yohanna Toro
 */
public class NotFoundShipMessage extends Exception{

    public  NotFoundShipMessage(ErrorMessage notFoundShipMessage) {

        super(notFoundShipMessage.message);
    }
}

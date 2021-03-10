package quasar.operation.demo.exception;

/**
 * @author Yohanna Toro
 */
public class NotFoundShipPosition extends Exception{

    public  NotFoundShipPosition(ErrorMessage notFoundShipPosition) {

        super(notFoundShipPosition.message);
    }


}

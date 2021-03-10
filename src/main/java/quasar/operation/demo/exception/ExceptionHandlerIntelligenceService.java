package quasar.operation.demo.exception;

import com.mongodb.lang.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class ExceptionHandlerIntelligenceService {
    @ExceptionHandler(value
            = { NotFoundShipMessage.class, NotFoundShipPosition.class })

    @Nullable
    public final ResponseEntity<?> handleException(Exception ex, WebRequest request) {

        HttpHeaders headers = new HttpHeaders();
        String messageError = ex.getMessage();
        StatusMessageError statusMessageError = new StatusMessageError();
        statusMessageError.setState(HttpStatus.NOT_FOUND.name());
        statusMessageError.setErrorMessage(messageError);
        statusMessageError.setCode("404");
        return createHandleException(ex, request, headers, statusMessageError);
    }

    private ResponseEntity<?> createHandleException(Exception ex, WebRequest request, HttpHeaders headers,
                                                    StatusMessageError statusMessageError) {

        HttpStatus status;
        if (ex instanceof NotFoundShipMessage) {
            status = HttpStatus.NOT_FOUND;
            NotFoundShipMessage notFoundShipMessage = (NotFoundShipMessage) ex;
            return handleInternalException(notFoundShipMessage, statusMessageError, headers, status, request);
        }else if (ex instanceof NotFoundShipPosition) {
            status = HttpStatus.NOT_FOUND;
            NotFoundShipPosition notPossibleActionException = (NotFoundShipPosition) ex;
            return handleInternalException(notPossibleActionException, statusMessageError, headers, status, request);
        } else {

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleInternalException(ex, statusMessageError, headers, status, request);
        }
    }
    private ResponseEntity<?> handleInternalException(Exception ex, @Nullable StatusMessageError body, HttpHeaders headers,
                                                      HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}

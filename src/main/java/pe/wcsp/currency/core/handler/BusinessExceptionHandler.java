package pe.wcsp.currency.core.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.wcsp.currency.dto.response.ObjectResponse;
import pe.wcsp.currency.core.exception.BusinessException;

@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ObjectResponse> handleBusinessException(BusinessException ex) {
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(ObjectResponse.builder()
                        .statusCode(ex.getStatusCode())
                        .message(ex.getErrorMessage())
                        .build());
    }

}

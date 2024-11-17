package pe.wcsp.currency.core.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private final Integer statusCode;
    private final String errorMessage;

    public BusinessException(String message) {
        super(message);
        this.statusCode = HttpStatus.BAD_REQUEST.value();
        this.errorMessage = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

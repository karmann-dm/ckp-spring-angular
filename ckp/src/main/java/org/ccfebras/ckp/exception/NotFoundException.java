package org.ccfebras.ckp.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
public class NotFoundException extends RuntimeException {
    public NotFoundException(String resourceName, String field, Object value) {
        super(String.format("%s with %s = %s not found", resourceName, field, value));
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

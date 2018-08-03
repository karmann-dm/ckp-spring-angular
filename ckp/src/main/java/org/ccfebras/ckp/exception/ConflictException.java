package org.ccfebras.ckp.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException(String entityName, String conflictedField, Object conflictValue) {
        super(String.format(
                "Duplicate in %s.%s, conflict by value '%s'",
                entityName,
                conflictedField,
                conflictValue
        ));
    }

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}

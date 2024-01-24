package org.vero_slaves.zootopia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Family not found")
public class FamilyNotFoundException extends Exception {

    public FamilyNotFoundException(String message) {
        super(message);
    }

    public FamilyNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
    
}

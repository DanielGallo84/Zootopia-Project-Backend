package org.vero_slaves.zootopia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Gender not found")
public class GenderNotFoundException extends Exception {

    public GenderNotFoundException(String message) {
        super(message);
    }

    public GenderNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
    
}
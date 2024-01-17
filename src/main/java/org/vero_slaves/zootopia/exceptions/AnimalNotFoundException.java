package org.vero_slaves.zootopia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Animal not found")
public class AnimalNotFoundException extends AnimalException {

    public AnimalNotFoundException(String message) {
        super(message);
    }

    public AnimalNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
    
}
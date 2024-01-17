package org.vero_slaves.zootopia.exceptions;

public class AnimalException extends RuntimeException {

    public AnimalException(String message) {
        super(message);
    }

    public AnimalException(String message, Throwable cause) {
        super(message, cause);
    }

}

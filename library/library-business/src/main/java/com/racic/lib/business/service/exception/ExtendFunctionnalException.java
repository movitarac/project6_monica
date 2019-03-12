package com.racic.lib.business.service.exception;

public class ExtendFunctionnalException extends Exception {

    public ExtendFunctionnalException(String message) {
        super(message);
    }

    public ExtendFunctionnalException(String message, Throwable cause) {
        super(message, cause);
    }
}


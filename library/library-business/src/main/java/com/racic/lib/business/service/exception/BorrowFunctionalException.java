package com.racic.lib.business.service.exception;

public class BorrowFunctionalException extends Exception{

    public BorrowFunctionalException(String message) {
        super(message);
    }

    public BorrowFunctionalException(String message, Throwable cause) {
        super(message, cause);
    }
}

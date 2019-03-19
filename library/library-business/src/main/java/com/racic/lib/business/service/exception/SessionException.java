package com.racic.lib.business.service.exception;

public class SessionException extends Exception{

    public SessionException(String message) {
        super(message);
    }


    public SessionException(String message, Throwable cause) {
        super(message, cause);
    }

}

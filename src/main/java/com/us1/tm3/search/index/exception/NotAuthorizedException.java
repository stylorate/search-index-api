package com.us1.tm3.search.index.exception;

public class NotAuthorizedException extends Exception {
    public NotAuthorizedException(String message) {
        super(message);
    }

    public NotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}

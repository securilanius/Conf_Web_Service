package com.example.conf_web_service.exceptions;

public class ConfException extends RuntimeException {
    public ConfException(String message) {
        super(message);
    }

    public ConfException(String message, Throwable cause) {
        super(message, cause);
    }
}

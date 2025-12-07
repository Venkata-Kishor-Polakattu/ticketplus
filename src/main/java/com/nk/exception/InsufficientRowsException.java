package com.nk.exception;

public class InsufficientRowsException extends RuntimeException {
    public InsufficientRowsException(String message) {
        super(message);
    }
}

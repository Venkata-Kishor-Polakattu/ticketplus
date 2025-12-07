package com.nk.exception;

public class DuplicateSeatSelectionException extends RuntimeException{
    public DuplicateSeatSelectionException(String message){
        super(message);
    }
}

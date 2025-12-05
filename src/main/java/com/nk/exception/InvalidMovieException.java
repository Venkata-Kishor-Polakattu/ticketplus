package com.nk.exception;

public class InvalidMovieException extends RuntimeException{
    public InvalidMovieException(String message){
        super(message);
    }
}

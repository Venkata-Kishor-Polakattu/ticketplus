package com.nk.exception;

public class InvalidMovie extends RuntimeException{
    public InvalidMovie(String message){
        super(message);
    }
}

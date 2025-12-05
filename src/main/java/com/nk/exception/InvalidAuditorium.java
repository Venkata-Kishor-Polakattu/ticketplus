package com.nk.exception;

public class InvalidAuditorium extends RuntimeException{
    public InvalidAuditorium(String msg){
        super(msg);
    }
}

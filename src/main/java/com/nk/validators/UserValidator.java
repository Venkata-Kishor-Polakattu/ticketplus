package com.nk.validators;

import com.nk.exception.InvalidMovieException;

public class UserValidator {
    static String[] invalidValues=MovieValidator.nums;

    public void validateUserName(String name){
            for (int i = 0; i < invalidValues.length; i++) {
                if (name.contains(invalidValues[i])){
                    throw  new InvalidMovieException("Invalid Name, Name must not contain numbers and special characters");
                }
            }
    }
}

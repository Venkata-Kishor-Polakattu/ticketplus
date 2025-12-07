package com.nk.validators;

import com.nk.enums.Certification;
import com.nk.exception.InvalidMovieException;

public class MovieValidator {

    static final String[] nums={"0","1","2","3","4","5","6","7","8","9","!",",",".",":","?","@","#","$","%","^","&","*"};

    public void validateLanguage(String language){
        for (int i = 0; i < nums.length; i++) {
            if (language.contains(nums[i])){
                throw  new InvalidMovieException("Invalid language, language must not contain numbers and special characters");
            }
        }
    }

    public void validateDuration(Integer duration){
        if (duration < 60){
            throw  new InvalidMovieException("Movie Duration must be greater than 60 Minutes");
        }
    }

    public void validateCertification(Certification certification){
        if (certification != Certification.A && certification!= Certification.U_A){
            throw  new InvalidMovieException("Movie Certification must be either A or U_A");
        }
    }

}

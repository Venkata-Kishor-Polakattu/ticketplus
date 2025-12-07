package com.nk.validators;

import com.nk.exception.InsufficientRowsException;
import com.nk.exception.InvalidAuditoriumException;

public class AuditoriumValidator {

    public void validateColumns(Integer columns){
        if (columns<10) throw new InvalidAuditoriumException("Insufficient Seat Columns, Seat Columns must be greater than 10");
    }

    public void validateSeatRows(Integer seatRows){
        if (seatRows<10){
            throw new InsufficientRowsException("Insufficient Seat Rows, Seat rows must be greater than 10");
        }
    }

}

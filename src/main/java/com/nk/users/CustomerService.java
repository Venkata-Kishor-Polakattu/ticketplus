package com.nk.users;

import com.nk.exception.InvalidShowException;

public interface CustomerService {
    void viewSeats() throws InvalidShowException;
    void bookTickets();
    void confirmPayment();
    void cancelBooking();
}

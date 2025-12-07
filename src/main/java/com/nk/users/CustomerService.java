package com.nk.users;

import com.nk.exception.ShowNotFoundException;

public interface CustomerService {
    void viewSeats() throws ShowNotFoundException;
    void bookTickets();
    void confirmPayment();
    void cancelBooking();
}

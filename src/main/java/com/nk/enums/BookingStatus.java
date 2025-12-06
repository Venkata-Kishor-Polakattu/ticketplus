package com.nk.enums;

public enum BookingStatus {
    BOOKED,        // Seat is successfully booked & confirmed
    CANCELLED,     // User cancelled the booking
    PENDING,       // Booking initiated but not completed (optional)
    EXPIRED        // Payment/hold expired (optional)
}

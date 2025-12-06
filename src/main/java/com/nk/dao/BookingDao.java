package com.nk.dao;

import com.nk.beans.Booking;
import com.nk.beans.Seat;
import org.hibernate.Session;

import java.util.List;

public interface BookingDao {
    void saveBooking(Session session, Booking booking);
    boolean isSeatBooked(Session session,Long showId,Long seatId);
    List<Booking> getBookingsByShow(Session session,Long showId);
}

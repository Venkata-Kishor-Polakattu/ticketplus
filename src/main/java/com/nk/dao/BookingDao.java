package com.nk.dao;

import com.nk.beans.Booking;
import org.hibernate.Session;

import java.util.List;

public interface BookingDao {
    Booking generateBooking(Session session,Long showId, String seatNos) throws Exception;


    Booking getBookingById(Session session,Long bookingId);

    List<Booking> getBookingsByShow(Session session,Long showId);

    void cancelBooking(Session session,Booking booking);
}

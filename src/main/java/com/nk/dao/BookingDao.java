package com.nk.dao;

import com.nk.beans.Booking;
import com.nk.beans.Seat;
import com.nk.exception.InvalidShowException;
import org.hibernate.Session;

import java.util.List;

public interface BookingDao {
    Booking generateBooking(Session session,Long showId, String seatNos) throws Exception;

    boolean isSeatBooked(Session session,Long showId,Long seatId);

    List<Booking> getBookingsByShow(Session session,Long showId);

}

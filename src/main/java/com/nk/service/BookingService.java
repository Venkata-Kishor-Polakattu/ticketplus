package com.nk.service;

import com.nk.beans.Seat;
import com.nk.config.DBConfig;
import org.hibernate.Session;

import java.util.List;

public interface BookingService {
    void bookSeat(Session session,Long showId, Long seatId);
    List<Seat> getAvailableSeats(Session session,Long showId);
}

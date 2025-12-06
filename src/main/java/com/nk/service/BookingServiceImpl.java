package com.nk.service;

import com.nk.beans.Seat;
import org.hibernate.Session;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public void bookSeat(Session session, Long showId, Long seatId) {
    }

    @Override
    public List<Seat> getAvailableSeats(Session session,Long showId) {
        return List.of();
    }
}

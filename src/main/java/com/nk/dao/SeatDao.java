package com.nk.dao;

import com.nk.beans.Seat;
import com.nk.enums.SeatStatus;
import org.hibernate.Session;

import java.util.List;

public interface SeatDao {
    void addSeat(Session session, Long seatId);
    Seat getSeat(Session session,Long seatId);
    void updateSeat(Session session,Long seatId);
    void deleteSeat(Session session,Long seatId);
    List<Seat> getSeatsByStatus(Session session,SeatStatus status, Long aid);
    List<Seat> getSeatsByAid(Session session,Long aid);
}

package com.nk.dao;

import com.nk.beans.Seat;
import com.nk.enums.SeatStatus;
import com.nk.exception.ShowNotFoundException;
import org.hibernate.Session;

import java.util.List;

public interface SeatDao {
    List<Seat> getSeatsByAuditId(Session session, Long aid);

    List<Seat> getSeatsByShowId(Session session, Long showId) throws ShowNotFoundException;

    Seat getSingleSeatByShowIdAndSeatNo(Session session, Long showId, String seatNo);


    List<Seat> getSeatsByStatus(Session session,SeatStatus status, Long aid);

    void displayAvailableSeatsByShowId(Session session,Long showId) throws ShowNotFoundException;

}

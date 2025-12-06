package com.nk.dao;

import com.nk.beans.Seat;
import com.nk.config.DBConfig;
import com.nk.enums.SeatStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SeatDaoImpl implements  SeatDao {
    @Override
    public void addSeat(Session session,Long seatId) {
    }

    @Override
    public Seat getSeat(Session session,Long seatId) {
        return null;
    }

    @Override
    public void updateSeat(Session session,Long seatId) {

    }

    @Override
    public void deleteSeat(Session session,Long seatId) {

    }

    @Override
    public List<Seat> getSeatsByStatus(Session session,SeatStatus status, Long aid) {
        Query<Seat> nativeQuery=session.createQuery("from Seat s where s.status=:status and s.auditorium=:id",Seat.class);
        nativeQuery.setParameter("id",aid);
        nativeQuery.setParameter("status",status);

        List<Seat> seats=nativeQuery.getResultList();
        return seats;
    }

    @Override
    public List<Seat> getSeatsByAid(Session session,Long aid) {
        Query<Seat> nativeQuery=session.createQuery("from Seat s where s.auditorium.id=:id",Seat.class);
        nativeQuery.setParameter("id",aid);
        List<Seat> seats=nativeQuery.getResultList();
        return seats;
    }
}

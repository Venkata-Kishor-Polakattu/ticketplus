package com.nk.dao;

import com.nk.beans.Auditorium;
import com.nk.beans.Seat;
import com.nk.beans.Show;
import com.nk.enums.SeatStatus;
import com.nk.exception.InvalidShowException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SeatDaoImpl implements  SeatDao {

    @Override
    public List<Seat> getSeatsByStatus(Session session,SeatStatus status, Long aid) {
        Query<Seat> nativeQuery=session.createQuery("from Seat s where s.status=:status and s.auditorium=:id",Seat.class);
        nativeQuery.setParameter("id",aid);
        nativeQuery.setParameter("status",status);

        List<Seat> seats=nativeQuery.getResultList();
        return seats;
    }

    @Override
    public List<Seat> getSeatsByAuditId(Session session, Long aid) {
        Query<Seat> nativeQuery=session.createQuery("from Seat s where s.auditorium.id=:id",Seat.class);
        nativeQuery.setParameter("id",aid);
        List<Seat> seats=nativeQuery.getResultList();
        return seats;
    }

    @Override
    public List<Seat> getSeatsByShowId(Session session, Long showId) throws InvalidShowException {
        Show show=session.find(Show.class,showId);
        if (show == null) {
            throw new InvalidShowException("Invalid Show Id, check once again");
        }

        Auditorium auditorium =show.getAuditorium();

        List<Seat> seats= getSeatsByAuditId(session,auditorium.getAid());
        return seats;
    }

    @Override
    public Seat getSingleSeatByShowIdAndSeatNo(Session session, Long showId, String seatNo) throws InvalidShowException {
        Show show=session.find(Show.class,showId);
        Query<Seat> nativeQuery=session.createQuery("from Seat s where s.auditorium.id=:audit_id and s.show.id=:show_id and s.seatNo=:seat_no",Seat.class);
        nativeQuery.setParameter("audit_id",show.getAuditorium().getAid());
        nativeQuery.setParameter("show_id",showId);
        nativeQuery.setParameter("seat_no",seatNo);
        Seat seat=nativeQuery.getSingleResult();
        return seat;
    }

    @Override
    public Seat getSingleSeatByShowId(Session session, Long showId) throws InvalidShowException {
        Show show=session.find(Show.class,showId);
        Query<Seat> nativeQuery=session.createQuery("from Seat s where s.auditorium.id=:audit_id and s.show.id=:show_id",Seat.class);
        nativeQuery.setParameter("audit_id",show.getAuditorium().getAid());
        nativeQuery.setParameter("show_id",showId);
        return null;
    }

    @Override
    public void displayAvailableSeatsByShowId(Session session,Long showId) throws InvalidShowException {
        List<Seat> seats=getSeatsByShowId(session,showId).stream().filter(seat->seat.getStatus().equals(SeatStatus.AVAILABLE)).toList();
        System.out.println("Available Seats:");
        for (Seat seat:seats) {
            System.out.print(seat.getSeatNo()+", ");
        }
    }

}

package com.nk.dao;

import com.nk.beans.Seat;
import com.nk.beans.Show;
import com.nk.enums.SeatStatus;
import com.nk.enums.ShowStatus;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ShowDaoImpl implements ShowDao {

    SeatDao seatDao = FactoryClass.getSeatDao();

    @Override
    public void addShow(Session session,Show show) {
        System.out.println("Adding Show");
        session.persist(show);
        session.flush();

        System.out.println("Show Added successfully with id:"+show.getId());

        //clone seats from Auditorium
        Query<Seat> nativeQuery=session.createQuery("from Seat s where s.auditorium.id=:aid",Seat.class);
        nativeQuery.setParameter("aid",show.getAuditorium().getAid());
        List<Seat> seats = nativeQuery.getResultList();

        List<Seat> showSeats=seats.stream().map(audiSeat->{
            Seat seat=new Seat();
            seat.setSeatNo(audiSeat.getSeatNo());
            seat.setStatus(SeatStatus.AVAILABLE);
            seat.setShow(show);
            seat.setAuditorium(show.getAuditorium());
            session.persist(seat);
            return seat;
        }).toList();

        //persists all cloned objects
        showSeats.forEach(session::persist);
    }

    @Override
    public void deleteShow(Session session,Long showId) {

    }

    @Override
    public List<Show> getShowsByStatus(Session session,ShowStatus showStatus) {
        Query<Show> nativeQuery=session.createQuery("from Show s where s.status=:status",Show.class);
        nativeQuery.setParameter("status",showStatus);

        List<Show> shows=nativeQuery.getResultList();
        return shows;
    }


    @Override
    public Show getShowById(Session session,Long showId) {
        System.out.println("Getting Show by Show Id");
        Query<Show> nativeQuery=session.createQuery("select s from Show s join fetch s.movie join fetch s.auditorium where s.id=:id",Show.class);
        nativeQuery.setParameter("id",showId);

        Show show=nativeQuery.getSingleResult();
        return show;
    }

    @Override
    public void updateShow(Session session,Long showId) {
    }
}

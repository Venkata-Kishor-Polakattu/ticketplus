package com.nk.dao;

import com.nk.beans.Booking;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookingDaoImpl implements BookingDao {
    private static ShowDao showDao = FactoryClass.getShowDao();
    @Override
    public void saveBooking(Session session,Booking booking) {
        System.out.println("saving booking");
        session.persist(booking);
    }

    @Override
    public boolean isSeatBooked(Session session,Long showId, Long seatId) {
        return false;
    }

    @Override
    public List<Booking> getBookingsByShow(Session session,Long showId) {

        String hql="from Booking b where b.show.id=:showId";
        Query<Booking>  query=session.createQuery(hql, Booking.class).setParameter("showId",showId);
        List<Booking> bookingList=query.getResultList();
        return bookingList;
    }
}

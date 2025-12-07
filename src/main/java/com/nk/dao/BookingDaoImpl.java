package com.nk.dao;

import com.nk.beans.Booking;
import com.nk.beans.Show;
import com.nk.enums.BookingStatus;
import com.nk.enums.PaymentStatus;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookingDaoImpl implements BookingDao {

    @Override
    public Booking generateBooking(Session session,Long showId, String seatNos) throws Exception {
        System.out.println("Generating Booking details");
        Booking booking = new Booking();
        booking.setShow(session.find(Show.class,showId));
        booking.setBookingStatus(BookingStatus.BOOKED);
        booking.setPaymentStatus(PaymentStatus.PENDING);
        booking.setBookedSeats(seatNos);
        session.persist(booking);
        return booking;
    }

    @Override
    public boolean isSeatBooked(Session session,Long showId, Long seatId) {
        return false;
    }

    @Override
    public Booking getBookingById(Session session,Long bookingId) {
       Booking booking= session.find(Booking.class,bookingId);
        return booking;
    }

    @Override
    public List<Booking> getBookingsByShow(Session session,Long showId) {

        String hql="from Booking b where b.show.id=:showId";
        Query<Booking>  query=session.createQuery(hql, Booking.class).setParameter("showId",showId);
        List<Booking> bookingList=query.getResultList();
        return bookingList;
    }
}
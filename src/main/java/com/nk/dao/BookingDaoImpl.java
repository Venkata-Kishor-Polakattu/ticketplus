package com.nk.dao;

import com.nk.beans.Booking;
import com.nk.beans.Seat;
import com.nk.beans.Show;
import com.nk.enums.BookingStatus;
import com.nk.enums.PaymentStatus;
import com.nk.enums.SeatStatus;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookingDaoImpl implements BookingDao {
    SeatDao seatDao=FactoryClass.getSeatDao();

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
    public void cancelBooking(Session session,Booking booking){
        String[] seats=booking.getBookedSeats().split(",");
        Show show=booking.getShow();
        for (int i=0;i<seats.length;i++) {
            Seat seat=seatDao.getSingleSeatByShowIdAndSeatNo(session,show.getId(),seats[i]);
            seat.setStatus(SeatStatus.AVAILABLE);
            session.merge(seat);
        }
        session.remove(booking);
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
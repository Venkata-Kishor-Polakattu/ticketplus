package com.nk.dao;

import com.nk.beans.Booking;
import com.nk.config.DBConfig;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookingDaoTest {
    private static BookingDao bookingDao= FactoryClass.getBookingDao();
    public static void main(String[] args) {
        //testGetBookingsByShow(2l);
    }

    public static void testGetBookingsByShow(Long showId) {
        Session session= DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Booking> bookings=bookingDao.getBookingsByShow(session,showId);
            System.out.println(bookings);
            System.out.println("✅Get Booking By Show passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.err.println("❌Get Booking By Show failed the TEST");
            e.printStackTrace();
        }
    }
}

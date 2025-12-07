package com.nk.dao;

import com.nk.config.DBConfig;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SeatDaoTest {
   private static SeatDao seatDao= FactoryClass.getSeatDao();
    public static void main(String[] args) {
        //testGetSeatByShowId(1l);
    }

    public static void testGetSeatByShowId(Long showId){
        Session session= DBConfig.getSession();
        Transaction tx= session.beginTransaction();
        try {
            System.out.println(seatDao.getSingleSeatByShowIdAndSeatNo(session, showId,"B9"));
            tx.commit();
            System.out.println("✅ GetSeatByShowId passed the TEST");
        }catch (Exception e){
            System.err.println("❌ GetSeatByShowId failed the TEST");
            e.printStackTrace();
        }
    }
}

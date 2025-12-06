package com.nk.dao;

import com.nk.beans.Auditorium;
import com.nk.config.DBConfig;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class AuditoriumDaoTest {
    public static void main(String[] args) {
        //testAddAuditorium();
        //testGetAuditorium(1l);
        //testGetAllAuditoriums();
    }


    private static AuditoriumDao auditoriumDao = FactoryClass.getAuditoriumDao();

    public static void testAddAuditorium(){
        Session session= DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        Auditorium auditorium=new Auditorium();
        auditorium.setName("AA");
        auditorium.setSeatCols(16);
        auditorium.setSeatRows(12);
        auditorium.setCreatedAt(LocalDate.now());
        auditorium.setUpdatedAt(LocalDate.now());
        auditorium.setCreatedBy("Kishor");
        try {
            auditoriumDao.addAuditorium(session,auditorium);
            System.out.println("✅ADD Auditorium passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.err.println("❌ADD Auditorium failed the TEST");
            e.printStackTrace();
        }
    }

    public static void testGetAuditorium(Long auditorium_id){
        Session session= DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        try {
            Auditorium auditorium= auditoriumDao.getAuditorium(session,auditorium_id);
            System.out.println(auditorium);
            System.out.println("✅GET Auditorium passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.err.println("❌GET Auditorium failed the TEST");
            e.printStackTrace();
        }
    }
    public static void testGetAllAuditoriums(){
        Session session= DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Auditorium> auditoriums = auditoriumDao.getAllAuditorium(session);
            System.out.println(auditoriums);
            System.out.println("✅GET All Auditorium passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.err.println("❌GET All Auditorium failed the TEST");
            e.printStackTrace();
        }
    }
}

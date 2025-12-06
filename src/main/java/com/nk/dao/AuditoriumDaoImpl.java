package com.nk.dao;

import com.nk.beans.Auditorium;
import com.nk.config.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuditoriumDaoImpl implements AuditoriumDao {


    @Override
    public void addAuditorium(Session session,Auditorium auditorium) {
        System.out.println("adding auditorium");
        auditorium.generateSeats();
        session.persist(auditorium);
    }

    @Override
    public Auditorium getAuditorium(Session session,Long audit_Id) {
        System.out.println("Searching auditorium");
        Auditorium auditorium=session.find(Auditorium.class, audit_Id);
        return auditorium;
    }

    @Override
    public void updateAuditorium(Session session,Long audit_Id) {

    }

    @Override
    public void deleteAuditorium(Session session,Long audit_Id) {

    }

    @Override
    public List<Auditorium> getAllAuditorium(Session session) {
        List<Auditorium> auditoriums=session.createQuery("from Auditorium",Auditorium.class).list();
        return auditoriums;
    }
}

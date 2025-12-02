package com.nk.dao;

import com.nk.beans.Auditorium;
import com.nk.config.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuditoriumDaoImpl implements AuditoriumDao {

    Session session;
    Transaction tx;

    @Override
    public void addAuditorium(Auditorium auditorium) {
        System.out.println("adding auditorium");

        session= DBConfig.getSession();
        tx=session.beginTransaction();

        session.persist(auditorium);
        tx.commit();
        System.out.println("Auditorium added successfully");
        session.close();
    }

    @Override
    public Auditorium getAuditorium(Long audit_Id) {
        System.out.println("Searching auditorium");
        session= DBConfig.getSession();
        Auditorium auditorium=session.find(Auditorium.class, audit_Id);
        return auditorium;
    }

    @Override
    public void updateAuditorium(Long audit_Id) {

    }

    @Override
    public void deleteAuditorium(Long audit_Id) {

    }
}

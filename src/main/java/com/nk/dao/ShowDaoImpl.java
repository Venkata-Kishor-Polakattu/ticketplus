package com.nk.dao;

import com.nk.beans.Show;
import com.nk.config.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShowDaoImpl implements ShowDao {

    Session session=null;
    Transaction tx=null;

    @Override
    public void addShow(Show show) {
        System.out.println("Adding Show");
        session= DBConfig.getSession();
        tx=session.beginTransaction();
        session.persist(show);
        tx.commit();
        System.out.println("Show Added successfully");
        session.close();
    }

    @Override
    public void deleteShow(Long showId) {

    }

    @Override
    public void getShow(Long showId) {

    }

    @Override
    public void updateShow(Long showId) {

    }
}

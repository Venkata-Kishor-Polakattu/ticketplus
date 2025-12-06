package com.nk.dao;

import com.nk.beans.Show;
import com.nk.config.DBConfig;
import com.nk.enums.ShowStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ShowDaoImpl implements ShowDao {


    @Override
    public void addShow(Session session,Show show) {
        System.out.println("Adding Show");
        session.persist(show);
        System.out.println("Show Added successfully");
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

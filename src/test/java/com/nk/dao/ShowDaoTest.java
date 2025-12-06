package com.nk.dao;

import com.nk.beans.Auditorium;
import com.nk.beans.Movie;
import com.nk.beans.Show;
import com.nk.config.DBConfig;
import com.nk.enums.ShowStatus;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

public class ShowDaoTest {
    private static final ShowDao showDao=new ShowDaoImpl();

    public static void main(String[] args) {
        //testAddShow();
    }
    public static void testAddShow(){
        AuditoriumDao  auditoriumDao= FactoryClass.getAuditoriumDao();
        MovieDao movieDao= FactoryClass.getMovieDao();

        Session session= DBConfig.getSession();
        Transaction tx= session.beginTransaction();

        Show show = new Show();
        show.setShowTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now());
        show.setStatus(ShowStatus.OPEN);

        Auditorium auditorium =auditoriumDao.getAuditorium(session,1l);
        show.setAuditorium(auditorium);

        Movie movie = movieDao.getMovieById(session,1l);
        show.setMovie(movie);
        try {
            showDao.addShow(session,show);
            System.out.println("✅ ADD SHOW passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.out.println("❌ ADD SHOW failed the TEST");
            e.printStackTrace();
        }
    }
}

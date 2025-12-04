package com.nk.dao;

import com.nk.beans.Auditorium;
import com.nk.beans.Movie;
import com.nk.beans.Show;
import com.nk.enums.ShowStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShowDaoTest {
    private static final ShowDao showDao=new ShowDaoImpl();

    public static void main(String[] args) {
        //testAddShow();
    }
    public static void testAddShow(){
        AuditoriumDao  auditoriumDao=new AuditoriumDaoImpl();
        MovieDao movieDao=new MovieDaoImpl();

        Show show = new Show();
        show.setShowTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now());
        show.setStatus(ShowStatus.OPEN);

        Auditorium auditorium =auditoriumDao.getAuditorium(1l);
        show.setAuditorium(auditorium);

        Movie movie = movieDao.getMovieById(1l);
        show.setMovie(movie);
        try {
            showDao.addShow(show);
            System.out.println("✅ ADD SHOW passed the TEST");
        }catch (Exception e){
            System.out.println("❌ ADD SHOW failed the TEST");
            e.printStackTrace();
        }
    }
}

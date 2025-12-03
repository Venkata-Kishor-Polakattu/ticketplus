package com.nk.service;

import com.nk.beans.Auditorium;
import com.nk.beans.Movie;
import com.nk.beans.Show;
import com.nk.dao.*;
import com.nk.dto.ShowDto;

import java.time.LocalDate;

public class ShowServiceImpl implements  ShowService {
    private static final ShowDao showDao=new ShowDaoImpl();
    static final AuditoriumDao auditoriumDao=new AuditoriumDaoImpl();
    static final MovieDao movieDao=new MovieDaoImpl();
    @Override
    public void addShow(Long aid,Long mid,ShowDto showDto) {
        Auditorium auditorium=auditoriumDao.getAuditorium(aid);
        Movie movie=movieDao.getMovie(mid);
        Show show=new Show();
        show.setAuditorium(auditorium);
        show.setMovie(movie);
        show.setShowTime(LocalDate.now());
    }
}

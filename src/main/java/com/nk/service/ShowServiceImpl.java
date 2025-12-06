package com.nk.service;

import com.nk.beans.Auditorium;
import com.nk.beans.Movie;
import com.nk.beans.Show;
import com.nk.dao.*;
import com.nk.dto.ShowDto;
import com.nk.enums.ShowStatus;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class ShowServiceImpl implements  ShowService {
    private static final ShowDao showDao= FactoryClass.getShowDao();
    static final AuditoriumDao auditoriumDao= FactoryClass.getAuditoriumDao();
    static final MovieDao movieDao= FactoryClass.getMovieDao();


    @Override
    public void addShow(Session session, ShowDto showDto) {
        Auditorium auditorium=auditoriumDao.getAuditorium(session,showDto.getAid());
        Movie movie=movieDao.getMovieById(session,showDto.getMid());
        Show show=new Show();
        show.setAuditorium(auditorium);
        show.setMovie(movie);
        show.setShowTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now().plusHours(movie.getDuration()/60).plusMinutes(movie.getDuration()%60));
        show.setStatus(ShowStatus.OPEN);
        show.setCreatedBy(showDto.getCreatedBy());
        showDao.addShow(session,show);
    }

    @Override
    public List<Show> getShows(Session session,ShowStatus showStatus) {
        List<Show> shows;
        shows=showDao.getShowsByStatus(session,showStatus);
        return shows;
    }
}

package com.nk.service;

import com.nk.beans.Movie;
import com.nk.dao.MovieDao;
import com.nk.dto.MovieDto;
import com.nk.enums.MovieStatus;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;

import java.util.List;


public class MovieServiceImpl implements MovieService {

    static MovieDao movieDao= FactoryClass.getMovieDao();

    @Override
    public void addMovie(Session session, MovieDto movieDto) { //here we've to convert MovieDto to Movie
        Movie movie=new Movie();
        //mapping MovieDto to Movie
        movie.setTitle(movieDto.getTitle());
        movie.setLanguage(movieDto.getLanguage());
        movie.setCertification(movieDto.getCertification());
        movie.setDuration(movieDto.getDuration());
        movie.setStatus(movieDto.getStatus());
        movie.setCreatedBy(movieDto.getCreatedBy());
        movie.setCreatedBy(movieDto.getCreatedBy());
        movieDao.addMovie(session,movie);
    }

    @Override
    public Movie getMovie(Session session,Long movieId) {
        return null;
    }

    @Override
    public List<Movie> getAvailableMovies(Session session) {
       List<Movie> movies= movieDao.getMoviesByStatus(session,MovieStatus.AVAILABLE);
       return movies;
    }
}

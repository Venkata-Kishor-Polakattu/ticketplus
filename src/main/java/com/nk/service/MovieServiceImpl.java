package com.nk.service;

import com.nk.beans.Movie;
import com.nk.dao.MovieDao;
import com.nk.dao.MovieDaoImpl;
import com.nk.dto.MovieDto;

import java.util.List;
import java.util.Scanner;


public class MovieServiceImpl implements MovieService {

    static MovieDao movieDao=new MovieDaoImpl();

    @Override
    public void addMovie(MovieDto movieDto) { //here we've to convert MovieDto to Movie
        Movie movie=new Movie();
        //mapping MovieDto to Movie
        movie.setTitle(movieDto.getTitle());
        movie.setLanguage(movieDto.getLanguage());
        movie.setCertification(movieDto.getCertification());
        movie.setDuration(movieDto.getDuration());
        movie.setStatus(movieDto.getStatus());
        movie.setCreatedBy(movieDto.getCreatedBy());
        movieDao.addMovie(movie);
    }

    @Override
    public Movie getMovie(Long movieId) {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
       List<Movie> movies= movieDao.getAvailableMovies();
       return movies;
    }
}

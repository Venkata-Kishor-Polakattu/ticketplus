package com.nk.dao;

import com.nk.beans.Movie;
import com.nk.enums.MovieStatus;
import org.hibernate.Session;

import java.util.List;

public interface MovieDao {
    void addMovie(Session session, Movie movie);

    Movie getMovieById(Session session,Long movieId);

    List<Movie> getMoviesByStatus(Session session,MovieStatus movieStatus);


    void updateMovie(Session session,Long movieId, Movie movie);

    void deleteMovie(Session session,Long movieId);
}

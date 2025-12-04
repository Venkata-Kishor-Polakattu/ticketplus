package com.nk.dao;

import com.nk.beans.Movie;
import com.nk.enums.MovieStatus;

import java.util.List;

public interface MovieDao {
    void addMovie(Movie movie);

    Movie getMovieById(Long movieId);

    List<Movie> getMoviesByStatus(MovieStatus movieStatus);


    void updateMovie(Long movieId, Movie movie);

    void deleteMovie(Long movieId);
}

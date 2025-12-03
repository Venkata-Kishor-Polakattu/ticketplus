package com.nk.dao;

import com.nk.beans.Movie;

import java.util.List;

public interface MovieDao {
    void addMovie(Movie movie);

    Movie getMovie(Long movieId);

    List<Movie> getAvailableMovies();

    void updateMovie(Long movieId, Movie movie);

    void deleteMovie(Long movieId);
}

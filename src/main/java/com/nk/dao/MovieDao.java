package com.nk.dao;

import com.nk.beans.Movie;

public interface MovieDao {
    public void addMovie(Movie movie);
    public Movie getMovie(Long movieId);
    public void updateMovie(Long movieId, Movie movie);
    public void deleteMovie(Long movieId);
}

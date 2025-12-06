package com.nk.service;

import com.nk.beans.Movie;
import com.nk.dto.MovieDto;
import org.hibernate.Session;

import java.util.List;

public interface MovieService {
    void addMovie(Session session, MovieDto movieDto);

    Movie getMovie(Session session,Long movieId);

    List<Movie> getAvailableMovies(Session session);

}

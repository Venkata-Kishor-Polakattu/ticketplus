package com.nk.service;

import com.nk.beans.Movie;
import com.nk.dto.MovieDto;

import java.util.List;

public interface MovieService {
    void addMovie(MovieDto movieDto);

    Movie getMovie(Long movieId);

    List<Movie> getAllMovies();

}

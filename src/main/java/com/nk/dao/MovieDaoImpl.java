package com.nk.dao;

import com.nk.beans.Movie;
import com.nk.config.DBConfig;
import com.nk.enums.MovieStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MovieDaoImpl implements MovieDao {

    @Override
    public void addMovie(Session session,Movie movie) {
        System.out.println("Adding movie");
        session.persist(movie);
        session.close();
    }


    @Override
    public Movie getMovieById(Session session,Long movieId) {
        System.out.println("Searching movie");

        //Movie foundMovie=session.find(Movie.class, movieId); --> without HQL

        String HQL="from Movie m where m.id=:id"; // -->with HQL
        Query<Movie> nativeQuery=session.createQuery(HQL,Movie.class);
        nativeQuery.setParameter("id",movieId);

        Movie foundMovie=nativeQuery.getSingleResult();
        return foundMovie;
    }

    @Override
    public List<Movie> getMoviesByStatus(Session session,MovieStatus movieStatus) {
        String HQL="from Movie m where m.status=:status";
        Query<Movie> nativeQuery=session.createQuery(HQL,Movie.class);
        nativeQuery.setParameter("status",movieStatus);

        Transaction tx=session.beginTransaction();
        List<Movie> movies=nativeQuery.getResultList();

        return movies;
    }


    @Override
    public void updateMovie(Session session,Long movieId, Movie movie) {
        System.out.println("Updating movie");


        Movie foundMovie= getMovieById(session,movieId);

        if (foundMovie != null) {
            foundMovie.setTitle(movie.getTitle());
            foundMovie.setLanguage(movie.getLanguage());
            foundMovie.setDuration(movie.getDuration());
            foundMovie.setCertification(movie.getCertification());
            foundMovie.setStatus(movie.getStatus());
            session.persist(foundMovie);
            System.out.println("Movie updated successfully");
        }else System.out.println("Movie not found");
    }


    @Override
    public void deleteMovie(Session session,Long movieId) {
        System.out.println("Deleting movie");

        Movie foundMovie= getMovieById(session,movieId);
        if (foundMovie != null) {
            session.remove(foundMovie);
            System.out.println("Movie deleted successfully");
        }else System.out.println("Movie not found");
    }
}

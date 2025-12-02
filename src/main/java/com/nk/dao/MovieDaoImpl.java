package com.nk.dao;

import com.nk.beans.Movie;
import com.nk.config.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDaoImpl implements MovieDao {
    Session session=null;
    Transaction tx=null;

    @Override
    public void addMovie(Movie movie) {
        System.out.println("Adding movie");

        session=DBConfig.getSession();
        tx=session.beginTransaction();
        session.persist(movie);
        tx.commit();
        session.close();
    }


    @Override
    public Movie getMovie(Long movieId) {
        Movie foundMovie;
        System.out.println("Searching movie");
        session=DBConfig.getSession();

        foundMovie=session.find(Movie.class, movieId);

        session.close();
        return foundMovie;
    }


    @Override
    public void updateMovie(Long movieId, Movie movie) {
        System.out.println("Updating movie");


        Movie foundMovie=getMovie(movieId);

        if (foundMovie != null) {
            session=DBConfig.getSession();
            tx=session.beginTransaction();
            foundMovie.setTitle(movie.getTitle());
            foundMovie.setLanguage(movie.getLanguage());
            foundMovie.setDuration(movie.getDuration());
            foundMovie.setCertification(movie.getCertification());
            foundMovie.setStatus(movie.getStatus());
            session.persist(foundMovie);
            tx.commit();
            session.close();
            System.out.println("Movie updated successfully");
        }else System.out.println("Movie not found");
    }


    @Override
    public void deleteMovie(Long movieId) {
        System.out.println("Deleting movie");

        Movie foundMovie=getMovie(movieId);
        if (foundMovie != null) {
            session=DBConfig.getSession();
            tx=session.beginTransaction();
            session.remove(foundMovie);
            tx.commit();
            session.close();
            System.out.println("Movie deleted successfully");
        }else System.out.println("Movie not found");
    }
}

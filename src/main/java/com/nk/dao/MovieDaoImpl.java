package com.nk.dao;

import com.nk.beans.Movie;
import com.nk.config.DBConfig;
import com.nk.enums.MovieStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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
    public Movie getMovieById(Long movieId) {
        System.out.println("Searching movie");
        session=DBConfig.getSession();

        //Movie foundMovie=session.find(Movie.class, movieId); --> without HQL

        String HQL="from Movie m where m.id=:id"; // -->with HQL
        Query<Movie> nativeQuery=session.createQuery(HQL,Movie.class);
        nativeQuery.setParameter("id",movieId);

        Movie foundMovie=nativeQuery.getSingleResult();

        session.close();
        return foundMovie;
    }

    @Override
    public List<Movie> getMoviesByStatus(MovieStatus movieStatus) {
        session=DBConfig.getSession();
        String HQL="from Movie m where m.status=:status";
        Query<Movie> nativeQuery=session.createQuery(HQL,Movie.class);
        nativeQuery.setParameter("status",movieStatus);
        List<Movie> movies=nativeQuery.getResultList();
        return movies;
    }


    @Override
    public void updateMovie(Long movieId, Movie movie) {
        System.out.println("Updating movie");


        Movie foundMovie= getMovieById(movieId);

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

        Movie foundMovie= getMovieById(movieId);
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

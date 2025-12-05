package com.nk.dao;

import com.nk.beans.Movie;
import com.nk.enums.Certification;
import com.nk.enums.MovieStatus;

public class MovieDaoTest {
    public static void main(String[] args) {
        //testAddMovie();//-->success
        //testGetMovie();
        //testUpdateMovie();
        //testGetAvailableMovies(); //-->success
    }

    static MovieDao movieDao =new MovieDaoImpl();
    public static void testAddMovie(){
        Movie movie=new Movie();
        movie.setTitle("Spirit");
        movie.setDuration(160);
        movie.setCertification(Certification.A);
        movie.setLanguage("Telugu");
        movie.setStatus(MovieStatus.AVAILABLE);
        try {
            movieDao.addMovie(movie);
            System.out.println("✅ ADD MOVIE passed the TEST");
        }catch (Exception e){
            System.err.println("❌ ADD MOVIE failed the TEST");
            e.printStackTrace();
        }
    }

    public static void testGetMovie(){
        try {
            System.out.println(movieDao.getMovieById(1l));
            System.out.println("✅ GET MOVIE passed the TEST");
        }catch (Exception e){
            System.err.println("❌ GET MOVIE failed the TEST");
            e.printStackTrace();
        }
    }
    public static void testGetAvailableMovies(){
        try {
            System.out.println(movieDao.getMoviesByStatus(MovieStatus.AVAILABLE));
            System.out.println("✅ GET Available Movies passed the TEST");
        }catch (Exception e){
            System.err.println("❌ GET Available Movies failed the TEST");
            e.printStackTrace();
        }
    }
    public static void testUpdateMovie(){
        Movie movie=new Movie();
        movie.setId(1l);
        movie.setTitle("Salaar");
        movie.setDuration(170);
        movie.setCertification(Certification.A);
        movie.setLanguage("Kannada");
        movie.setStatus(MovieStatus.NOT_AVAILABLE);
        try {
            movieDao.updateMovie(movie.getId(),movie);
            System.out.println("✅UPDATE MOVIE passed the TEST");
        }catch (Exception e){
            System.err.println("❌UPDATE MOVIE failed the TEST");
            e.printStackTrace();
        }
    }
    public static void testDeleteMovie(){
        try {
            movieDao.deleteMovie(56l);
        }catch (Exception e){
            System.err.println("❌ DELETE MOVIE failed the TEST");
            e.printStackTrace();
        }
    }
}
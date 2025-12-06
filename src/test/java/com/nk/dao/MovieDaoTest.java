package com.nk.dao;

import com.nk.beans.Movie;
import com.nk.config.DBConfig;
import com.nk.enums.Certification;
import com.nk.enums.MovieStatus;
import com.nk.factory.FactoryClass;
import com.nk.users.AdminService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDaoTest {
    public static void main(String[] args) {
        //testAddMovie();//-->success
        //testGetMovie();
        //testUpdateMovie();
        //testGetAvailableMovies(); //-->success
    }

    static MovieDao movieDao =new MovieDaoImpl();
    public static void testAddMovie(){
        AdminService adminService= FactoryClass.getAdminService();
        try {
            adminService.createMovie();
            System.out.println("✅ ADD MOVIE passed the TEST");
        }catch (Exception e){
            System.err.println("❌ ADD MOVIE failed the TEST");
            e.printStackTrace();
        }
    }

    public static void testGetMovie(){
        Session session= DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        try {
            System.out.println(movieDao.getMovieById(session,1l));
            System.out.println("✅ GET MOVIE passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.err.println("❌ GET MOVIE failed the TEST");
            e.printStackTrace();
        }
    }
    public static void testGetAvailableMovies(){
        Session session= DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        try {
            System.out.println(movieDao.getMoviesByStatus(session,MovieStatus.AVAILABLE));
            System.out.println("✅ GET Available Movies passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.err.println("❌ GET Available Movies failed the TEST");
            e.printStackTrace();
        }
    }
    public static void testUpdateMovie(){
        Session session= DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        Movie movie=new Movie();
        movie.setId(1l);
        movie.setTitle("Salaar");
        movie.setDuration(170);
        movie.setCertification(Certification.A);
        movie.setLanguage("Kannada");
        movie.setStatus(MovieStatus.NOT_AVAILABLE);
        try {
            movieDao.updateMovie(session,movie.getId(),movie);
            System.out.println("✅UPDATE MOVIE passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.err.println("❌UPDATE MOVIE failed the TEST");
            e.printStackTrace();
        }
    }
    public static void testDeleteMovie(){
        Session session= DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        try {
            movieDao.deleteMovie(session,56l);
            System.out.println("✅DELETE MOVIE passed the TEST");
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            session.close();
            System.err.println("❌ DELETE MOVIE failed the TEST");
            e.printStackTrace();
        }
    }
}
package com.nk.users;

import com.nk.beans.Movie;
import com.nk.config.DBConfig;
import com.nk.factory.FactoryClass;
import com.nk.service.MovieService;
import com.nk.service.MovieServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AdminServiceTests {
    private static AdminService adminService = FactoryClass.getAdminService();
    public static void main(String[] args) {
        //testCreateAuditorium();
        //testGetAvailableMovies();
        //testCreateMovie();
        //testCreateShow(); //-->success
    }
    public static void testCreateAuditorium(){
        try {
            System.out.println("Test Create Auditorium");
            adminService.createAuditorium();
            System.out.println("✅ Admin Create Movie passed the TEST");
        }catch (Exception e){
            System.out.println("❌ Admin Create Movie failed the TEST");
        }
    }

    private static void testCreateShow() {
        try {
            System.out.println("Testing Create Show method");
            adminService.createShow();
            System.out.println("✅ Admin Create Movie passed the TEST");
        } catch (Exception e) {
            System.out.println("❌ Admin Create Movie failed the TEST");
        }
    }
    private static void testCreateMovie() {
        try {
            System.out.println("Testing CreateMovie method");
            adminService.createMovie();
            System.out.println("✅ Admin Create Movie passed the TEST");
        } catch (Exception e) {
            System.out.println("❌ Admin Create Movie failed the TEST");
        }
    }

    private static void testGetAvailableMovies() {
        Session session= DBConfig.getSession();
        Transaction tx= session.beginTransaction();
        try {
            System.out.println("Testing GetAvailableMovies method");
            MovieService movieService = new MovieServiceImpl();
            System.out.println("Available Movies");

            for (Movie movie:movieService.getAvailableMovies(session))
                System.out.println(movie);

            System.out.println("✅ Get Available Movies passed the TEST");
            tx.commit();
            session.close();
        } catch (Exception e) {
            tx.rollback();
            session.close();
            System.out.println("❌ Get Available Movies failed the TEST");
        }
    }
}

package com.nk.users;

import com.nk.beans.Movie;
import com.nk.service.MovieService;
import com.nk.service.MovieServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AdminServiceTests {
    private static AdminService adminService = new AdminServiceImpl();
    public static void main(String[] args) {

        testGetAvailableMovies();
        //testCreateMovie();
        //testCreateShow(); //-->success
    }

    private static void testCreateShow() {
        try {
            System.out.println("Testing Create Show method");
            adminService.createShow();
            System.out.println("✅ Admin Create Movie passed the TEST");
        } catch (Exception e) {
            System.out.println("✅❌ Admin Create Movie failed the TEST");
        }
    }
    private static void testCreateMovie() {
        try {
            System.out.println("Testing CreateMovie method");
            AdminService adminService = new AdminServiceImpl();
            adminService.createMovie();
            System.out.println("✅ Admin Create Movie passed the TEST");
        } catch (Exception e) {
            System.out.println("✅❌ Admin Create Movie failed the TEST");
        }
    }

    private static void testGetAvailableMovies() {
        try {
            System.out.println("Testing GetAvailableMovies method");
            MovieService movieService = new MovieServiceImpl();
            System.out.println("Available Movies");
            for (Movie movie:movieService.getAvailableMovies())
                System.out.println(movie);

            System.out.println("✅ Get Available Movies passed the TEST");
        } catch (Exception e) {
            System.out.println("❌ Get Available Movies failed the TEST");
        }
    }
}

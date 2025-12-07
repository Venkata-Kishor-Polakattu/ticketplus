package com.nk.factory;

import com.nk.dao.*;
import com.nk.service.*;
import com.nk.users.AdminService;
import com.nk.users.AdminServiceImpl;
import com.nk.users.CustomerService;
import com.nk.users.CustomerServicesImpl;
import com.nk.validators.AuditoriumValidator;
import com.nk.validators.MovieValidator;
import com.nk.validators.UserValidator;

import java.util.Scanner;

public class FactoryClass {
    private static AdminService adminService;

    public static AdminService getAdminService(){
        if(adminService==null){
            adminService=new AdminServiceImpl();
        }
        return adminService;
    }

    private static CustomerService customerServices;
    public static CustomerService getCustomerService() {
        if (customerServices == null) {
            customerServices = new CustomerServicesImpl();
        }
        return customerServices;
    }

    private static MovieService movieService;
    public static MovieService getMovieService(){
        if (movieService==null){
            movieService=new MovieServiceImpl();
        }
        return movieService;
    }

    private static BookingService bookingService;
    public static BookingService getBookingServiceFactory(){
        if (bookingService==null){
            bookingService=new BookingServiceImpl();
        }
        return bookingService;
    }


    private static ShowService showService;
    public static ShowService getShowService(){
        if (showService==null){
            showService=new ShowServiceImpl();
        }
        return showService;
    }

    private static Scanner scanner = new  Scanner(System.in);

    public static Scanner getScanner(){
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    private static AuditoriumDao auditoriumDao;
    public static AuditoriumDao getAuditoriumDao() {
        if (auditoriumDao == null) {
            auditoriumDao = new AuditoriumDaoImpl();
        }
        return auditoriumDao;
    }

    private static MovieDao movieDao;
    public static MovieDao getMovieDao() {
        if (movieDao == null) {
            movieDao=new MovieDaoImpl();
        }
        return movieDao;
    }

    private static BookingDao bookingDao;
    public static BookingDao getBookingDao() {
        if (bookingDao == null) {
            bookingDao = new BookingDaoImpl();
        }
        return bookingDao;
    }

    private static SeatDao seatDao;
    public static SeatDao getSeatDao() {
        if (seatDao == null) {
            seatDao=new SeatDaoImpl();
        }
        return seatDao;
    }

    private static ShowDao showDao;
    public static ShowDao getShowDao() {
        if (showDao == null) {
            showDao = new ShowDaoImpl();
        }
        return showDao;
    }

    private static MovieValidator movieValidator;
    public static MovieValidator getMovieValidator() {
        if (movieValidator == null) {
            movieValidator = new MovieValidator();
        }
        return movieValidator;
    }

    private static UserValidator userValidator;
    public static UserValidator getUserValidator() {
        if (userValidator == null) {
            userValidator = new UserValidator();
        }
        return userValidator;
    }

    private static AuditoriumValidator auditoriumValidator;
    public static AuditoriumValidator getAuditoriumValidator() {
        if (auditoriumValidator == null) {
            auditoriumValidator = new AuditoriumValidator();
        }
        return auditoriumValidator;
    }
}

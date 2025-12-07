package com.nk.users;

import com.nk.beans.Auditorium;
import com.nk.beans.Movie;
import com.nk.config.DBConfig;
import com.nk.dao.AuditoriumDao;
import com.nk.dto.MovieDto;
import com.nk.dto.ShowDto;
import com.nk.enums.Certification;
import com.nk.enums.MovieStatus;
import com.nk.exception.InvalidAuditoriumException;
import com.nk.exception.InvalidMovieException;
import com.nk.factory.FactoryClass;
import com.nk.service.MovieService;
import com.nk.service.ShowService;
import com.nk.service.ShowServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.*;

public class AdminServiceImpl implements AdminService {

    static final Scanner scanner = FactoryClass.getScanner();
    private static final MovieService movieService =FactoryClass.getMovieService();
    @Override
    public void createMovie() {
        Session session=DBConfig.getSession();
        Transaction tx=session.beginTransaction();
        try {
            System.out.println("Admin ADD Movie");
            System.out.println("Enter Movie Details");
            System.out.println("--------------------");
            MovieDto movieDto = new MovieDto();

            System.out.print("Enter title  :");
            String title = scanner.next();
            movieDto.setTitle(title);

            System.out.print("Enter language :");
            String language = scanner.next();
            movieDto.setLanguage(language);

            System.out.print("Enter duration(minutes)  :");
            Integer duration = scanner.nextInt();
            scanner.nextLine();
            movieDto.setDuration(duration);

            System.out.print("Enter certification :");
            Certification certification = Certification.valueOf(scanner.next());
            movieDto.setCertification(certification);

            movieDto.setStatus(MovieStatus.AVAILABLE);

            System.out.print("Enter Your name :");
            String name=scanner.next();
            movieDto.setCreatedBy(name);

            System.out.println("Check movie Details");
            System.out.println(movieDto);

            movieService.addMovie(session,movieDto);
            tx.commit();
            System.out.println("✅ Movie Added Successfully");
            session.close();
        }catch (Exception e){
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            System.out.println("❌Movie Creation Failed");
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    AuditoriumDao auditoriumDao= FactoryClass.getAuditoriumDao();
    @Override
    public void createShow() {
        Session session=DBConfig.getSession();
        Transaction tx=session.beginTransaction();
        try {
            System.out.println("Admin show creating");
            List<Auditorium> auditoriums = auditoriumDao.getAllAuditorium(session);//show list of auditoriums
            Set<Long> audit_set = new HashSet<>(); //--> to store the ids to check with user input

            System.out.println("Enter Show Details");
            System.out.println("--------------------");
            System.out.println("Audit_Id  Name   seat_capacity");//displaying all Auditoriums
            for (Auditorium auditorium : auditoriums) {
                System.out.println(auditorium.getAid() + "          " + auditorium.getName() + "             " + (auditorium.getSeatCols() * auditorium.getSeatRows()));
                audit_set.add(auditorium.getAid());
            }

            System.out.print("Enter Auditorium Id you want :");// select Audid Id (Scanner)
            Long aid = scanner.nextLong();
            scanner.nextLine();
            if (!audit_set.contains(aid)) {
                throw new InvalidAuditoriumException("Invalid Auditorium Id and enter the available one");
            }

            List<Movie> movies = movieService.getAvailableMovies(session);//displaying all movies
            Set<Long> movie_set = new HashSet<>();
            System.out.println("Movie_Id   Name");// Show list of movies
            for (Movie movie : movies) {
                System.out.println(movie.getId() + "          " + movie.getTitle());
                movie_set.add(movie.getId());
            }

            System.out.print("Enter Movie Id you want :");// select Movie Id;
            Long mid = scanner.nextLong();
            scanner.nextLine();
            if (!movie_set.contains(mid)) {
                throw new InvalidMovieException("Invalid Movie Id and enter the available one");
            }

            System.out.print("Enter your name :");
            String name = scanner.next();

            ShowService showService = new ShowServiceImpl();
            ShowDto showDto = new ShowDto();
            showDto.setAid(aid);showDto.setMid(mid);showDto.setCreatedBy(name);
            showService.addShow(session,showDto);// call addShowO(audiID,movieId,showsDto);
            System.out.println("✅Show Created Successfully");
            tx.commit();
            session.close();
        }catch (Exception e){
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            System.out.println("❌Show Creation Failed");
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void createAuditorium() {
        Session session=DBConfig.getSession();
        Transaction tx=session.beginTransaction();
        try {
            Auditorium auditorium = new Auditorium();
            System.out.println("Enter Auditorium Details");
            System.out.println("--------------------");

            System.out.print("Enter Auditorium Name you want :");
            String name = scanner.next();
            auditorium.setName(name); //auditorium.setName("Ranga");

            System.out.print("Enter Seat Columns :");
            Integer seatCols = scanner.nextInt();
            scanner.nextLine();
            auditorium.setSeatCols(seatCols);//auditorium.setSeatCols(20);

            System.out.print("Enter Seat Rows :");
            Integer seatRows = scanner.nextInt();
            scanner.nextLine();
            auditorium.setSeatRows(seatRows);//auditorium.setSeatRows(25);

            System.out.print("Enter your name :");
            auditorium.setCreatedBy(scanner.next());

            auditorium.setCreatedAt(LocalDate.now());
            auditorium.setUpdatedAt(LocalDate.now());


            auditoriumDao.addAuditorium(session,auditorium);
            tx.commit();
            System.out.println("✅Auditorium Added Successfully");
            session.close();
        } catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            System.out.println("❌Show Creation Failed");
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

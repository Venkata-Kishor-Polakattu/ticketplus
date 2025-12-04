package com.nk.users;

import com.nk.beans.Auditorium;
import com.nk.beans.Movie;
import com.nk.dao.AuditoriumDao;
import com.nk.dao.AuditoriumDaoImpl;
import com.nk.dto.MovieDto;
import com.nk.dto.ShowDto;
import com.nk.enums.Certification;
import com.nk.enums.MovieStatus;
import com.nk.service.MovieService;
import com.nk.service.MovieServiceImpl;
import com.nk.service.ShowService;
import com.nk.service.ShowServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AdminServiceImpl implements AdminService {

    static final Scanner scanner = new Scanner(System.in);
    private static final MovieService movieService = new MovieServiceImpl();
    @Override
    public void createMovie() {
        try {
            System.out.println("Admin ADD Movie");
            System.out.println("Enter Movie Details");
            System.out.println("--------------------");
            MovieDto movieDto = new MovieDto();

            System.out.println("Enter title: ");
            String title = scanner.next();
            movieDto.setTitle(title);

            System.out.println("Enter language: ");
            String language = scanner.next();
            movieDto.setLanguage(language);

            System.out.println("Enter duration(minutes): ");
            Integer duration = scanner.nextInt();
            movieDto.setDuration(duration);

            System.out.println("Enter certification: ");
            Certification certification = Certification.valueOf(scanner.next());
            movieDto.setCertification(certification);

            MovieStatus status = MovieStatus.AVAILABLE;
            movieDto.setStatus(status);

            movieDto.setCreatedBy(204l);

            System.out.println("Check movie Details");
            System.out.println(movieDto);

            movieService.addMovie(movieDto);
            System.out.println("✅ Movie Added Successfully");
        }catch (Exception e){
            System.out.println("❌ Movie Creation Failed");
            e.printStackTrace();
        }
    }

    @Override
    public void createShow() {
        AuditoriumDao auditoriumDao=new AuditoriumDaoImpl();
        System.out.println("Admin Create show");
        System.out.println("Enter Show Details");
        System.out.println("--------------------");
        List<Auditorium> auditoriums=auditoriumDao.getAllAuditorium();//show list of auditoriums
        Set<Long> audit_set=new HashSet<>(); //--> to store the ids to check with user input
        System.out.println("Audit_Id   Name   seat_capacity");//displaying all Auditoriums
        for (Auditorium auditorium:auditoriums){
            System.out.println(auditorium.getAid()+"   "+ auditorium.getName()+"   "+(auditorium.getSeatCols()*auditorium.getSeatRows()));
            audit_set.add(auditorium.getAid());
        }

        System.out.println("Enter Auditorium Id you want ");// select Audid Id (Scanner)
        Long aid=scanner.nextLong();
        ShowDto showDto=new ShowDto();// Create ShowsDto object

        if (audit_set.contains(aid)){
            showDto.setAid(aid);
        }else {
            System.out.println("please check the auditorium Id and enter the available one");
        }

        List<Movie> movies=movieService.getAvailableMovies();//displaying all movies
        Set<Long> movie_set=new HashSet<>();
        System.out.println("Movie_Id   Name");// Show list of movies
        for (Movie movie:movies){
            System.out.println(movie.getId()+"     "+movie.getTitle());
            movie_set.add(movie.getId());
        }

        System.out.println("Enter Movie Id you want ");// select Movie Id;
        Long mid=scanner.nextLong();
        if (movie_set.contains(mid)){
            showDto.setMid(mid);
        }else {
            System.out.println("please check the Movie Id and enter the available one");
        }

        ShowService showService=new ShowServiceImpl();
        showService.addShow(aid,mid,showDto);// call addShowO(audiID,movieId,showsDto);
    }
}

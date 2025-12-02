package com.nk.users;

import com.nk.dto.MovieDto;
import com.nk.enums.Certification;
import com.nk.enums.MovieStatus;
import com.nk.service.MovieService;
import com.nk.service.MovieServiceImpl;

import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

    private static final Scanner scanner = new Scanner(System.in);
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
}

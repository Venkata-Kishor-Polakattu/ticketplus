package com.nk.users;

import com.nk.beans.Auditorium;
import com.nk.beans.Seat;
import com.nk.beans.Show;
import com.nk.config.DBConfig;
import com.nk.dao.*;
import com.nk.enums.SeatStatus;
import com.nk.enums.ShowStatus;
import com.nk.exception.InvalidShowException;
import com.nk.factory.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;
public class CustomerServicesImpl implements CustomerService {

    private Scanner scanner = FactoryClass.getScanner();
    private ShowDao showDao = FactoryClass.getShowDao();
    private MovieDao movieDao= FactoryClass.getMovieDao();
    private AuditoriumDao  auditoriumDao = FactoryClass.getAuditoriumDao();
    private SeatDao seatDao = FactoryClass.getSeatDao();
    private BookingDao bookingDao = FactoryClass.getBookingDao();

    @Override
    public void viewSeats() throws InvalidShowException{
        Session session = DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        List<Show> shows=showDao.getShowsByStatus(session,ShowStatus.OPEN);

        if (shows.isEmpty()) {
            System.out.println("❌ No running shows available");
            return;
        }

        System.out.println("Available shows:");
        System.out.println("-----------------");
        System.out.println("ShowId Auditorium Movie");
        //Displaying the available shows,Movie,Auditorium
        for(Show show:shows){
            String movieName=show.getMovie().getTitle();
            String auditName=show.getAuditorium().getName();

            System.out.println(show.getId()+"    "+auditName+"    "+movieName);
        }

        System.out.print("Choose the Show id :");// here customer enter integer value so we have to do type casting
        Integer showId=scanner.nextInt();
        scanner.nextLine();

        Show show=showDao.getShowById(session,showId.longValue());
        if (show == null) {
            throw new InvalidShowException("Invalid Show Id, check once again");
        }

        Auditorium auditorium =show.getAuditorium();

        List<Seat> seats=seatDao.getSeatsByAid(session,auditorium.getAid());

        System.out.println("Seat Number :  Seat Status");
        for(Seat seat:seats){
            String status=(seat.getStatus().equals(SeatStatus.AVAILABLE))?"Available":"Booked";
            System.out.println(seat.getId()+"       : "+status);
        }
        tx.commit();
        session.close();
    }

    @Override
    public void bookTickets() {

    }

    @Override
    public void confirmPayment() {

    }

    @Override
    public void cancelBooking() {

    }
}

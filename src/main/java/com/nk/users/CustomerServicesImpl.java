package com.nk.users;

import com.nk.beans.Booking;
import com.nk.beans.Seat;
import com.nk.beans.Show;
import com.nk.config.DBConfig;
import com.nk.dao.*;
import com.nk.enums.BookingStatus;
import com.nk.enums.PaymentStatus;
import com.nk.enums.SeatStatus;
import com.nk.enums.ShowStatus;
import com.nk.exception.ShowNotFoundException;
import com.nk.factory.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;
public class CustomerServicesImpl implements CustomerService {

    private final Scanner scanner = FactoryClass.getScanner();
    private final ShowDao showDao = FactoryClass.getShowDao();
    private final MovieDao movieDao= FactoryClass.getMovieDao();
    private final AuditoriumDao  auditoriumDao = FactoryClass.getAuditoriumDao();
    private final SeatDao seatDao = FactoryClass.getSeatDao();
    private final BookingDao bookingDao = FactoryClass.getBookingDao();

    @Override
    public void viewSeats() throws ShowNotFoundException {
        System.out.println("Displaying the seats");
        Session session = DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Show> shows = showDao.getShowsByStatus(session, ShowStatus.OPEN);

            if (shows.isEmpty()) {
                System.out.println("❌ No running shows available");
                return;
            }

            System.out.println("Available shows:");
            System.out.println("-----------------");
            System.out.println("ShowId Auditorium Movie");
            //Displaying the available shows,Movie,Auditorium
            for (Show show : shows) {
                String movieName = show.getMovie().getTitle();
                String auditName = show.getAuditorium().getName();

                System.out.println(show.getId() + " | " + auditName + " | " + movieName);
            }

            System.out.print("Choose the Show id :");// here customer enter integer value so we have to do type casting
            Integer showId = scanner.nextInt();
            scanner.nextLine();

            List<Seat> seats = seatDao.getSeatsByShowId(session, showId.longValue());

            System.out.println("Seat Number :  Seat Status");
            for (Seat seat : seats) {
                String status = (seat.getStatus().equals(SeatStatus.AVAILABLE)) ? "Available" : "Booked";
                System.out.println(seat.getSeatNo() + "       : " + status);
            }

            tx.commit();
        }catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            System.out.println("❌Tickets Booked Failed");
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void bookTickets() {
        System.out.println("Booking Tickets");
        Session session = DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        System.out.println();
        try {
            System.out.println("Booking Tickets ");
            System.out.println("------------------");
            List<Show> shows = showDao.getShowsByStatus(session, ShowStatus.OPEN);

            //list the available shows
            if (shows.isEmpty()) {
                System.out.println("❌ No running shows available");
                return;
            }

            System.out.println("Open Shows:");
            for (Show s : shows) {
                System.out.println(s.getId() + " | " +
                        s.getAuditorium().getName() + " | " +
                        s.getMovie().getTitle());
            }

            //take showId input
            System.out.print("Enter the Show id :");
            Integer id=scanner.nextInt();
            scanner.nextLine();
            Long showId = id.longValue();

            //display the available seats
            System.out.println("Available Seats");
            List<Seat> availableSeats=seatDao.getSeatsByShowId(session, showId);

            if (availableSeats.isEmpty()) {
                System.out.println("❌ No seats available");
                return;
            }

            List<Seat> notBooked=availableSeats.stream().filter(seat -> seat.getStatus().equals(SeatStatus.AVAILABLE)).toList();
            for (Seat seat : notBooked) {
                System.out.println(seat.getSeatNo());
            }


            System.out.print("\nHow many seats do you want to book? ");
            int count = scanner.nextInt();
            scanner.nextLine();

            if (count > availableSeats.size()) {
                System.out.println("❌ Only " + availableSeats.size() + " seats are available");
                return;
            }

            List<String> seatInputs=new ArrayList<>();
            for(int i=1;i<=count;i++){
                System.out.print("Enter "+i+" Seat No :"); //chance to check whether the entered seat is booked or not
                seatInputs.add(scanner.nextLine());
            }


            List<String> successfullyBookedSeats=new ArrayList<>();
            for (String seatNo : seatInputs) {

                // Fetch the specific seat
                Seat seat = seatDao.getSingleSeatByShowIdAndSeatNo(session, showId,seatNo);

                if (seat == null) {
                    System.out.println("❌ Invalid seat number: " + seatNo);
                    continue;
                }

                if (seat.getStatus() == SeatStatus.BOOKED) {
                    System.out.println("❌ Seat already booked: " + seatNo);
                    continue;
                }

                // BOOK THE SEAT
                seat.setStatus(SeatStatus.BOOKED);
                session.merge(seat);
                successfullyBookedSeats.add(seatNo);

                System.out.println("✅ Seat " + seatNo + " successfully booked");
            }

            String bookedSeats = String.join(",", successfullyBookedSeats);

            Booking booking=bookingDao.generateBooking(session,showId,bookedSeats);
            tx.commit();
            System.out.println("✅Tickets Booked Successfully");
            System.out.println("Your booking details :"+booking);
        } catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            System.out.println("❌Tickets Booked Failed");
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void confirmPayment() {
        Session session = DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        System.out.println();
        try {
            System.out.println("Confirming Payment");
            System.out.println("-------------------");
            System.out.print("Enter Booking Id :");
            Integer id=scanner.nextInt();
            scanner.nextLine();
            Long bookingId=id.longValue();

            //get the booking details
            Booking booking=bookingDao.getBookingById(session,bookingId);


            //checks whether the booking id valid or not
            if (booking == null) {
                System.out.println("❌ Invalid Booking Id, please try again.");
                return;
            }


            //checks whether the seats are booked or not
            if (!booking.getBookingStatus().equals(BookingStatus.BOOKED)) {
                System.out.println("Tickets are not booked yet, please book them first");
                return;
            }

            if (booking.getPaymentStatus().equals(PaymentStatus.SUCCESS)){
                System.out.println("✅ Payment was done already");
                return;
            }

            String[] allSeats=booking.getBookedSeats().split(",");
            int total_price=allSeats.length*150;
            System.out.println("cost per seat : 150 Rs");
            System.out.println("Total amount to be paid :"+total_price+" Rs");

            System.out.println("Enter the amount to be paid :");
            int entered_amount=scanner.nextInt();
            scanner.nextLine();

            while (entered_amount!=total_price){
                System.out.println("Enter exact amount to be paid :");
                entered_amount=scanner.nextInt();
                scanner.nextLine();
            }

            booking.setPaymentStatus(PaymentStatus.SUCCESS);
            booking.setTotal_price(entered_amount);
            session.merge(booking);
            tx.commit();
            System.out.println("✅ Payment successful");

        }catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            System.out.println("❌Payment Failed");
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void cancelBooking() {
        Session session = DBConfig.getSession();
        Transaction tx = session.beginTransaction();
        System.out.println();
        try {
            System.out.println("Cancelling Booking");
            System.out.println("--------------------");
            System.out.print("Enter Booking Id :");
            Integer id=scanner.nextInt();
            scanner.nextLine();
            Long bookingId=id.longValue();

            while (bookingId<=0){
                System.out.print("Booking must be greater than 0 enter again :");
                bookingId=scanner.nextLong();
                scanner.nextLine();
            }

            //Get booking details first
            Booking booking=bookingDao.getBookingById(session,bookingId);

            if (booking == null) {
                System.out.println("❌ Invalid Booking Id, please try again.");
                return;
            }

            if (!booking.getBookingStatus().equals(BookingStatus.BOOKED)) {
                System.out.println("Payment was not done yet, you can leave");
                bookingDao.cancelBooking(session,booking);
                return;
            }

            bookingDao.cancelBooking(session,booking);
            tx.commit();
            System.out.println("Booking cancelled successfully, your amount will be credited to your account within 24 hours");
        }catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            System.out.println("❌Payment Failed");
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
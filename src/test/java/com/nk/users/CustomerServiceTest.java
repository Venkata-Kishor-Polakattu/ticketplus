package com.nk.users;

import com.nk.config.DBConfig;
import com.nk.dao.ShowDao;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;

public class CustomerServiceTest {
   private static CustomerService customerService = FactoryClass.getCustomerService();

    public static void main(String[] args) {
        //testViewSeats();
        //testBookSeats();
        //testConfirmPayment();
        //testCancelBooking();
    }
    public static void testCancelBooking(){
        try {
            customerService.cancelBooking();
            System.out.println("✅ Cancel Booking passed the TEST");
        } catch (Exception e) {
            System.out.println("❌ Cancel Booking failed the TEST");
            e.printStackTrace();
        }
    }

    public static void testConfirmPayment(){
        try {
            customerService.confirmPayment();
            System.out.println("✅ Customer View Seats passed the TEST");
        } catch (Exception e) {
            System.out.println("❌ Customer View Seats failed the TEST");
            e.printStackTrace();
        }
    }

    public static void testViewSeats(){
        try {
            customerService.viewSeats();
            System.out.println("✅ Customer View Seats passed the TEST");
        } catch (Exception e) {
            System.out.println("❌ Customer View Seats failed the TEST");
            e.printStackTrace();
        }
    }

    public static void testBookSeats(){
        try {
            customerService.bookTickets();
            System.out.println("✅ Customer Book Seats passed the TEST");
        } catch (Exception e) {
            System.out.println("❌ Customer Book Seats failed the TEST");
            e.printStackTrace();
        }
    }

}

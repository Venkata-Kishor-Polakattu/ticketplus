package com.nk.users;

import com.nk.config.DBConfig;
import com.nk.dao.ShowDao;
import com.nk.factory.FactoryClass;
import org.hibernate.Session;

public class CustomerServiceTest {
   private static CustomerService customerService = FactoryClass.getCustomerService();

    public static void main(String[] args) {
        //testViewSeats();
        //testGetShowById(1l);
        testBookSeats();
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

    public static void testGetShowById(Long showId){
        try {
            Session session= DBConfig.getSession();
            ShowDao showDao= FactoryClass.getShowDao();
            System.out.println(showDao.getShowById(session,showId));
            System.out.println("✅ Customer View Seats passed the TEST");
        } catch (Exception e) {
            System.out.println("❌ Customer View Seats failed the TEST");
        }
    }
}

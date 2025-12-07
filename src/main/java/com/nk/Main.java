package com.nk;

import com.nk.exception.InvalidShowException;
import com.nk.factory.FactoryClass;
import com.nk.users.AdminService;
import com.nk.users.CustomerService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final AdminService adminService = FactoryClass.getAdminService();
    private static final CustomerService customerService = FactoryClass.getCustomerService();


    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);

        System.out.println("===============WELCOME TO TICKETPLUS===============");
        while (true) {
            System.out.println("1. Admin\n" + "2. Customer\n" + "Any Key to exit");
            System.out.println();
            System.out.print("Enter your choice :");
            int choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("Admin Actions");
                    System.out.println("--------------");
                    System.out.println("1. Add Movie\n" + "2. Create Show\n" + "3. Add Auditorium\n" + "Any Key to exit");
                    System.out.print("Enter your choice :");
                    int adminChoice = sc.nextInt();
                    switch (adminChoice) {
                        case 1:
                            adminService.createMovie();
                            System.out.println();
                            break;
                        case 2:
                            adminService.createShow();
                            System.out.println();
                            break;
                        case 3:
                            adminService.createAuditorium();
                            System.out.println();
                            break;
                        default:
                            System.exit(0);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("CUSTOMER Actions \n" +
                            "1\uFE0F⃣ View Seats\n" +
                            "2\uFE0F⃣ Book Tickets\n" +
                            "3\uFE0F⃣ Confirm Payment\n" +
                            "4\uFE0F⃣ Cancel Booking\n" +
                            "5\uFE0F⃣ Exit");
                    System.out.print("Enter your choice :");
                    int customerChoice = sc.nextInt();
                    switch (customerChoice) {
                        case 1:
                            customerService.viewSeats();
                            break;
                        case 2:
                            customerService.bookTickets();
                            break;
                        case 3:
                            customerService.confirmPayment();
                            break;
                        case 4:
                            customerService.cancelBooking();
                            break;
                        default:
                            System.exit(0);
                            break;
                    }
                    break;
                default:
                    System.out.println("===============Thanks Visit Again===============");
                    System.exit(0);
            }
        }
    }
}
package com.nk;

import com.nk.service.*;
import com.nk.users.AdminService;
import com.nk.users.AdminServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final AdminService adminService = new AdminServiceImpl();
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("===============WELCOME TO TICKETPLUS===============");
        while (true) {
            System.out.println("1. Admin\n" + "2. Customer\n" + "Any Key to exit");
            System.out.print("Enter your choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Add Movie\n" + "2. Create Show\n" + "3. Add Auditorium\n" + "Any Key to exit");
                    System.out.print("Enter your choice :");
                    int adminChoice = sc.nextInt();
                    switch (adminChoice) {
                        case 1:
                            adminService.createMovie();
                            break;
                        case 2:
                            adminService.createShow();
                            break;
                        case 3:
                            adminService.createAuditorium();
                            break;
                        default:
                            System.exit(0);
                            break;
                    }
                    break;
                case 2:
                    break;
                default:
                    System.exit(0);
            }
            System.out.println("===============Thanks Visit Again===============");
        }
    }
}
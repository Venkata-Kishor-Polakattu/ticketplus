package com.nk.users;

import java.util.Scanner;

public class AdminServiceTests {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        testCreateMovie();
    }

    private static void testCreateMovie() {
        try {
            System.out.println("Testing CreateMovie method");
            AdminService adminService = new AdminServiceImpl();
            adminService.createMovie();
            System.out.println("✅ Admin Create Movie passed the TEST");
        } catch (Exception e) {
            System.out.println("✅❌ Admin Create Movie failed the TEST");
        }
    }
}

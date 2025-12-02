package com.nk.config;

import org.hibernate.Session;

public class DBConfigTest {
    public static void main(String[] args) {
        testConnection();
    }

    public static void testConnection(){
        System.out.println("Testing connection");
        try {
            Session s=DBConfig.getSession();
            s.close();
            DBConfig.shutDownSF();
            System.out.println("Test DB passed");
        }catch (Exception e){
            System.out.println("Test DB failed");
        }
    }
}

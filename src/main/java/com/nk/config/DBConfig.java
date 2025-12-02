package com.nk.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {
    private static SessionFactory sessionFactory;

    static {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        System.out.println("Configuration loaded");
    }

    public static Session getSession(){
       Session session= sessionFactory.openSession();
        System.out.println("Session opened");
        return session;
    }

    public static void shutDownSF(){
        sessionFactory.close();
        System.out.println("Session factory closed");
    }
}

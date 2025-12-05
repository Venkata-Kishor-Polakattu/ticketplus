package com.nk.dao;

import com.nk.beans.Auditorium;
import com.nk.beans.Movie;
import com.nk.enums.MovieStatus;

import java.time.LocalDate;
import java.util.List;

public class AuditoriumDaoTest {
    public static void main(String[] args) {
        //testAddAuditorium();
        //testGetAuditorium(1l);
        testGetAllAuditoriums();
    }


    private static AuditoriumDao auditoriumDao = new AuditoriumDaoImpl();
    public static void testAddAuditorium(){
        Auditorium auditorium=new Auditorium();
        auditorium.setName("Ranga");
        auditorium.setSeatCols(20);
        auditorium.setSeatRows(25);
        auditorium.setCreatedAt(LocalDate.now());
        auditorium.setUpdatedAt(LocalDate.now());
        auditorium.setCreatedBy("Sharath");
        try {
            auditoriumDao.addAuditorium(auditorium);
            System.out.println("✅ADD Auditorium passed the TEST");
        }catch (Exception e){
            System.err.println("❌ADD Auditorium failed the TEST");
            e.printStackTrace();
        }
    }

    public static void testGetAuditorium(Long auditorium_id){
        try {
            Auditorium auditorium= auditoriumDao.getAuditorium(auditorium_id);
            System.out.println(auditorium);
            System.out.println("✅GET Auditorium passed the TEST");
        }catch (Exception e){
            System.err.println("❌GET Auditorium failed the TEST");
            e.printStackTrace();
        }
    }
    public static void testGetAllAuditoriums(){
        try {
            List<Auditorium> auditoriums = auditoriumDao.getAllAuditorium();
            System.out.println(auditoriums);
            System.out.println("✅GET All Auditorium passed the TEST");
        }catch (Exception e){
            System.err.println("❌GET All Auditorium failed the TEST");
            e.printStackTrace();
        }
    }
}

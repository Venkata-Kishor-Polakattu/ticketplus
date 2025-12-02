package com.nk.dao;

import com.nk.beans.Auditorium;
import com.nk.beans.Movie;
import com.nk.enums.MovieStatus;

import java.time.LocalDate;

public class AuditoriumDaoTest {
    public static void main(String[] args) {
        testAddAuditorium();
    }


    private static AuditoriumDao auditoriumDao = new AuditoriumDaoImpl();
    public static void testAddAuditorium(){
        Auditorium auditorium=new Auditorium();
        auditorium.setName("NK");
        auditorium.setSeatCols(15);
        auditorium.setSeatRows(25);
        auditorium.setCreatedAt(LocalDate.now());
        auditorium.setUpdatedAt(LocalDate.now());
        try {
            auditoriumDao.addAuditorium(auditorium);
            System.out.println("✅ ADD Auditorium passed the TEST");
        }catch (Exception e){
            System.err.println("❌A DD Auditorium failed the TEST");
            e.printStackTrace();
        }
    }
}

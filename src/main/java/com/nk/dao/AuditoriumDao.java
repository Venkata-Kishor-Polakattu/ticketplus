package com.nk.dao;

import com.nk.beans.Auditorium;
import org.hibernate.Session;

import java.util.List;

public interface AuditoriumDao {
    void addAuditorium(Session session, Auditorium auditorium);
    Auditorium getAuditorium(Session session,Long audit_Id);
    void updateAuditorium(Session session,Long audit_Id);
    void deleteAuditorium(Session session,Long audit_Id);
    List<Auditorium> getAllAuditorium(Session session);
}

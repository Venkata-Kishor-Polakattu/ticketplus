package com.nk.dao;

import com.nk.beans.Auditorium;

import java.util.List;

public interface AuditoriumDao {
    void addAuditorium(Auditorium auditorium);
    Auditorium getAuditorium(Long audit_Id);
    void updateAuditorium(Long audit_Id);
    void deleteAuditorium(Long audit_Id);
    List<Auditorium> getAllAuditorium();
}

package com.nk.dao;

import com.nk.beans.Auditorium;

public interface AuditoriumDao {
    void addAuditorium(Auditorium auditorium);
    Auditorium getAuditorium(Long audit_Id);
    void updateAuditorium(Long audit_Id);
    void deleteAuditorium(Long audit_Id);
}

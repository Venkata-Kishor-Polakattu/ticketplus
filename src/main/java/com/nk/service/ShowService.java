package com.nk.service;

import com.nk.beans.Show;
import com.nk.dto.ShowDto;
import com.nk.enums.ShowStatus;
import org.hibernate.Session;

import java.util.List;

public interface ShowService {
    void addShow(Session session, ShowDto showDto);
    List<Show> getShows(Session session,ShowStatus  showStatus);
}

package com.nk.dao;

import com.nk.beans.Show;
import com.nk.enums.ShowStatus;
import org.hibernate.Session;

import java.util.List;

public interface ShowDao {
    Show getShowById(Session session, Long showId);
    void updateShow(Session session,Long showId);

    void addShow(Session session,Show show);

    void deleteShow(Session session,Long showId);
    List<Show> getShowsByStatus(Session session,ShowStatus showStatus);

}

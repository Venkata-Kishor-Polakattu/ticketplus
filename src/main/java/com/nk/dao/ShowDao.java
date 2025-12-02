package com.nk.dao;

import com.nk.beans.Show;

public interface ShowDao {
    void addShow(Show show);
    void getShow(Long showId);
    void updateShow(Long showId);
    void deleteShow(Long showId);
}

package com.nk.dao;

import com.nk.beans.Show;
import com.nk.dto.ShowDto;

import java.util.List;

public interface ShowDao {
    void getShow(Long showId);
    void updateShow(Long showId);

    void addShow(Show show);

    void deleteShow(Long showId);
    List<Show> getShows();

}

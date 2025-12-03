package com.nk.service;

import com.nk.dto.ShowDto;

public interface ShowService {
    void addShow(Long aid,Long mid,ShowDto showDto);
}

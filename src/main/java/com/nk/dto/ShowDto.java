package com.nk.dto;

public class ShowDto {
    private Long aid;
    private Long mid;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "ShowDto{" +
                "aid=" + aid +
                ", mid=" + mid +
                '}';
    }
}

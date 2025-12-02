package com.nk.beans;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auditorium")
public class Auditorium extends BaseEntity{ //id, name, seatRows, seatCols
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;
    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "seatRows", nullable = false)
    private Integer seatRows;

    @Column(name = "seatCols", nullable = false)
    private Integer seatCols;

    @OneToMany(mappedBy="auditorium",cascade = CascadeType.ALL)
    private List<Show>  shows=new ArrayList<>();

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatCols() {
        return seatCols;
    }

    public void setSeatCols(Integer seatCols) {
        this.seatCols = seatCols;
    }

    public Integer getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(Integer seatRows) {
        this.seatRows = seatRows;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", seatRows=" + seatRows +
                ", seatCols=" + seatCols +
                ", shows=" + shows +
                '}';
    }
}

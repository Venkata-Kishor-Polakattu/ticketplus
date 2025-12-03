package com.nk.beans;

import com.nk.enums.ShowStatus;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "shows")
public class Show extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="audit_id")
    private Auditorium  auditorium;

    @Column(name = "showTime")
    private LocalDate showTime;

    @Column(name = "endTime")
    private String endTime;

    @Enumerated(EnumType.STRING)
    private ShowStatus status;

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDate showTime) {
        this.showTime = showTime;
    }

    public ShowStatus getStatus() {
        return status;
    }

    public void setStatus(ShowStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Show{" +
                ", id=" + id +
                ", movie=" + movie +
                ", auditorium=" + auditorium +
                ", showTime='" + showTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status=" + status +
                '}';
    }
}

package com.nk.beans;

import com.nk.enums.ShowStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "shows")
public class Show extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="audit_id")
    private Auditorium  auditorium;

    @Column(name = "showTime")
    private LocalDateTime showTime;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private ShowStatus status;

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
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
                ", showTime='" + showTime.getHour()+":"+showTime.getMinute() + '\'' +
                ", endTime='" + endTime.getHour()+":"+endTime.getMinute() + '\'' +
                ", status=" + status +
                '}';
    }
}

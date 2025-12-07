package com.nk.beans;

import com.nk.enums.ShowStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "shows")
public class Show extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="audit_id")
    private Auditorium  auditorium;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> booking;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;

    @Column(name = "showTime")
    private LocalDateTime showTime;


    public List<Booking> getBooking() {
        return booking;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

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
                ", showTime='" + showTime.getHour()+":"+showTime.getMinute() + '\'' +
                ", endTime='" + endTime.getHour()+":"+endTime.getMinute() + '\'' +
                ", status=" + status +
                ", movie=" + movie.getTitle() +
                ", auditorium=" + auditorium.getName() +
                ", seats=" + seats.size() +
                '}';
    }
}

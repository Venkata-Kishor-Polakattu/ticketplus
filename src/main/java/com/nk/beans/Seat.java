package com.nk.beans;

import com.nk.enums.SeatStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seatNo")
    private String seatNo;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @ManyToOne()
    @JoinColumn(name = "audit_id")
    private Auditorium auditorium;

    /*@OneToMany(mappedBy = "seat")
    private List<Booking> bookings;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "auditorium=" + auditorium.getName() +
                ", id=" + id +
                ", seatNo='" + seatNo + '\'' +
                ", status=" + status +
                '}';
    }
}

package model;

import util.enums.ReservationStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    @ManyToOne
    private Customer customer;
    private Double price;
    @ManyToOne
    private Worker worker;
    private Integer days;
    @ManyToOne
    private Room room;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reservation(){}

    public Reservation(Long id, Date date, Customer customer, Double price, Integer days, Room room, ReservationStatus status) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.price = price;
        this.days = days;
        this.room = room;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}

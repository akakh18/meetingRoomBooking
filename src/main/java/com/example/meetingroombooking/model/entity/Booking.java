package com.example.meetingroombooking.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Room room;

    @Column
    private String startingDate;

    @Column
    private String endingDate;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

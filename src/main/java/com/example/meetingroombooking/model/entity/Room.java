package com.example.meetingroombooking.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REFRESH)
    private List<Invitation> invitations;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REFRESH)
    @Column
    private List<Booking> bookings;

    public Room() {
    }

    public Room(Integer capacity) {
        this.capacity = capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

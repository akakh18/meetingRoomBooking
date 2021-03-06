package com.example.meetingroombooking.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "invitations")
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "HOST_ID", referencedColumnName = "ID")
    private User host;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "ID")
    private User guest;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ID")
    private Room room;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getHost() {
        return host;
    }

    public User getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

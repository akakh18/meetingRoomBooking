package com.example.meetingroombooking.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer capacity;

    public Room() {
    }

    public Room(Integer capacity) {
        this.capacity = capacity;
    }

    @OneToMany(mappedBy = "room")
    private List<Invitation> invitations;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getCapacity() {
        return capacity;
    }
}

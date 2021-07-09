package com.example.meetingroombooking.model.entity;

import javax.persistence.*;

@Entity
public class Invitation {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User host;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User guest;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Room room;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

package com.example.meetingroombooking.model.dto;

import com.example.meetingroombooking.model.entity.Room;
import com.example.meetingroombooking.model.entity.User;

public class BookingDto {
    private User user;
    private Room room;
    private String starting;
    private String ending;

    public BookingDto() {}

    public BookingDto(User user, Room room, String starting, String ending) {
        this.user = user;
        this.room = room;
        this.starting = starting;
        this.ending = ending;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public String getStarting() {
        return starting;
    }

    public String getEnding() {
        return ending;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }
}

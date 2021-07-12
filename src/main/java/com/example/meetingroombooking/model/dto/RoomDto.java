package com.example.meetingroombooking.model.dto;

import com.example.meetingroombooking.model.entity.Room;

public class RoomDto {
    private final Integer capacity;

    public RoomDto(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomDto(Room room) {
        this.capacity = room.getCapacity();
    }

    public Room toEntity() {
        Room room = new Room();
        room.setCapacity(capacity);

        return room;
    }

}

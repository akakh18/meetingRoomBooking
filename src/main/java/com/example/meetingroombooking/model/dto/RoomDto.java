package com.example.meetingroombooking.model.dto;

import com.example.meetingroombooking.model.entity.Room;

public class RoomDto {
    private Integer capacity;

    public RoomDto(){}

    public RoomDto(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomDto(Room room) {
        this.capacity = room.getCapacity();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Room toEntity() {
        Room room = new Room();
        room.setCapacity(capacity);

        return room;
    }

}

package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.RoomDto;
import com.example.meetingroombooking.model.entity.Room;
import com.example.meetingroombooking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDto createRoom(RoomDto) {
        return null;
    }

    public List<RoomDto> getAllRooms() {
        List<RoomDto> result = new ArrayList<>();

        List<Room> rooms = roomRepository.findAll();

        for(Room room : rooms) {
            result.add(new RoomDto(room));
        }

        return result;
    }
}

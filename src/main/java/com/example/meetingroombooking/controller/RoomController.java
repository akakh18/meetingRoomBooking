package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.RoomDto;
import com.example.meetingroombooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomDto> > getAllRooms() {
        return null;
    }
}

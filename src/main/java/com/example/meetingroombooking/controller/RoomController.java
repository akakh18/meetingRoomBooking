package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.BookingDto;
import com.example.meetingroombooking.model.dto.InvitationDto;
import com.example.meetingroombooking.model.dto.RoomDto;
import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("")
    public ResponseEntity<List<RoomDto> > getAllRooms() {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getAllRooms());
    }

    @DeleteMapping
    public void removeBooking(@RequestBody BookingDto booking) {
    }

    @PostMapping
    public ResponseEntity<RoomDto> createNewRoom(@RequestBody RoomDto room) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.createNewRoom(room));
    }

    @PostMapping(path = "{roomId}")
    public ResponseEntity<InvitationDto> createInvitation(@PathVariable("roomId") Long roomId, @RequestBody UserDto guest) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.createInvitation(roomId,guest));
    }

}

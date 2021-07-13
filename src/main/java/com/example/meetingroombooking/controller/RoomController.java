package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.*;
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

    @PostMapping
    public ResponseEntity<RoomDto> createNewRoom(@RequestBody RoomDto room) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.createNewRoom(room));
    }

    @PutMapping("{roomId}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable("roomId") Long roomId, @RequestBody RoomDto newRoom) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.updateRoom(roomId, newRoom));
    }

    @DeleteMapping("{roomId}")
    public void deleteRoom(@PathVariable("roomId") Long roomId) {
        roomService.deleteRoom(roomId);
    }

    @PostMapping("{roomId}/book")
    public ResponseEntity<BookingDto> createBooking(@PathVariable Long roomId, @RequestBody Dates dates) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.createBooking(roomId, dates));
    }

    @DeleteMapping
    public void abortBooking(@RequestBody BookingDto booking) {
    }

    @PostMapping(path = "{roomId}")
    public ResponseEntity<InvitationDto> createInvitation(@PathVariable("roomId") Long roomId, @RequestBody UserDto guest) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.createInvitation(roomId,guest));
    }

}
package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.InvitationDto;
import com.example.meetingroombooking.model.dto.RoomDto;
import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/invite")
public class InvitationController {
    public InvitationService invitationService;

    @Autowired
    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @PostMapping
    public void invite(@RequestBody UserDto guest) {
        invitationService.invite(guest);
    }

    @PostMapping("/test")
    public void inviteTest(@RequestBody UserDto host, @RequestBody UserDto guest, @RequestBody RoomDto room) {
        invitationService.inviteTest(host, guest, room);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<InvitationDto>> getAllInvitations() {
        return ResponseEntity.status(HttpStatus.OK).body(invitationService.getAllInvitations());
    }

    @GetMapping("")
    public ResponseEntity<List<InvitationDto>> getAllInvitationForUser(@RequestParam Long userId) {
        return null;
    }
}

package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.model.dto.InvitationDto;
import com.example.meetingroombooking.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/invite")
public class InvitationController {
    public InvitationService invitationService;

    @Autowired
    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @PostMapping
    public void invite(@RequestBody InvitationDto invitation) {

    }

}

package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.InvitationDto;
import com.example.meetingroombooking.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitationService {
    private InvitationRepository invitationRepository;

    @Autowired
    public InvitationService(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    public void invite(InvitationDto invitation) {

    }
}

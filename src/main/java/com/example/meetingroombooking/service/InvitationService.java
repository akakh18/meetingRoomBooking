package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.InvitationDto;
import com.example.meetingroombooking.model.dto.RoomDto;
import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.model.entity.Invitation;
import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.repository.InvitationRepository;
import com.example.meetingroombooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvitationService {
    private final InvitationRepository invitationRepository;
    private final UserRepository userRepository;

    @Autowired
    public InvitationService(InvitationRepository invitationRepository, UserRepository userRepository) {
        this.invitationRepository = invitationRepository;
        this.userRepository = userRepository;
    }

    public List<Invitation> getAllInvitationForUser(User user) {
        return invitationRepository.findAllByGuest(user);
    }

    public void invite(UserDto user) {

    }

    public List<InvitationDto> getAllInvitations() {
        List<Invitation> invitations = invitationRepository.findAll();

        List<InvitationDto> result = new ArrayList<>();
        for(Invitation invitation : invitations) {
            result.add(new InvitationDto(invitation));
        }

        return result;
    }

    public void inviteTest(UserDto host, UserDto guest, RoomDto room) {
        invitationRepository.insertInvitation(host.toEntity(), guest.toEntity(), room.toEntity());
    }

}

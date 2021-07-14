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
    private final UserService userService;

    @Autowired
    public InvitationService(InvitationRepository invitationRepository, UserService userService) {
        this.invitationRepository = invitationRepository;
        this.userService = userService;
    }

    public List<Invitation> getAllInvitationForUser(User user) {
        return invitationRepository.findAllByGuest(user);
    }

    public List<InvitationDto> getAllInvitations() {
        List<Invitation> invitations = invitationRepository.findAll();

        List<InvitationDto> result = new ArrayList<>();
        for(Invitation invitation : invitations) {
            result.add(new InvitationDto(invitation));
        }

        return result;
    }

    public void rejectInvitation(Long id) {
        User user = userService.getCurrentUser().orElseThrow(() -> new RuntimeException("User does not exist"));
        Invitation invitation = invitationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Such invitation does not exist")
        );

        if(invitation.getGuest().getId().equals(user.getId())) {
            invitationRepository.delete(invitation);
        } else {
            throw new RuntimeException("You can't delete this invitation");
        }
    }
}

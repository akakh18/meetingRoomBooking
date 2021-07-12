package com.example.meetingroombooking.model.dto;

import com.example.meetingroombooking.model.entity.Invitation;
import com.example.meetingroombooking.model.entity.User;

public class InvitationDto {
    private User host;
    private User guest;

    public InvitationDto(User host, User guest) {
        this.host = host;
        this.guest = guest;
    }

    public InvitationDto(Invitation invitation) {
        this.host = invitation.getHost();
        this.guest = invitation.getGuest();
    }
}

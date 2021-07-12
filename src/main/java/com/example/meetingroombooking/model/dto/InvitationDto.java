package com.example.meetingroombooking.model.dto;

import com.example.meetingroombooking.model.entity.Invitation;
import com.example.meetingroombooking.model.entity.Room;
import com.example.meetingroombooking.model.entity.User;

import javax.swing.text.html.parser.Entity;

public class InvitationDto {
    private User host;
    private User guest;
    private Room room;

    public InvitationDto(User host, User guest, Room room) {
        this.host = host;
        this.guest = guest;
        this.room = room;
    }

    public InvitationDto(Invitation invitation) {
        this.host = invitation.getHost();
        this.guest = invitation.getGuest();
        this.room = invitation.getRoom();
    }

    public Invitation toEntity() {
        Invitation invitation = new Invitation();
        invitation.setHost(this.host);
        invitation.setGuest(this.guest);
        invitation.setRoom(this.room);

        return invitation;
    }
}

package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.InvitationDto;
import com.example.meetingroombooking.model.dto.RoomDto;
import com.example.meetingroombooking.model.dto.UserDto;
import com.example.meetingroombooking.model.entity.Invitation;
import com.example.meetingroombooking.model.entity.Room;
import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.repository.InvitationRepository;
import com.example.meetingroombooking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final UserService userService;
    private final InvitationRepository invitationRepository;

    private static final String ROOM_NOT_FOUND = "Room does not exist";
    private static final String USER_NOT_FOUND = "Authenticated user does not exist";

    @Autowired
    public RoomService(RoomRepository roomRepository, UserService userService, InvitationRepository invitationRepository) {
        this.roomRepository = roomRepository;
        this.userService = userService;
        this.invitationRepository = invitationRepository;
    }

    public List<RoomDto> getAllRooms() {
        List<RoomDto> result = new ArrayList<>();

        List<Room> rooms = roomRepository.findAll();

        for(Room room : rooms) {
            result.add(new RoomDto(room));
        }

        return result;
    }

    @Transactional
    public RoomDto createNewRoom(RoomDto room) {
        roomRepository.save(room.toEntity());
        return room;
    }

    public RoomDto updateRoom(Long id, RoomDto newRoomDto) {
        Room newRoom = new Room();
        newRoom.setId(id);
        newRoom.setCapacity(newRoomDto.getCapacity());
        roomRepository.save(newRoom);

        return newRoomDto;
    }

    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException(ROOM_NOT_FOUND));
        roomRepository.delete(room);
    }

    public InvitationDto createInvitation(Long roomId, UserDto guest) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException(ROOM_NOT_FOUND));
        User host = userService.getCurrentUser()
                .orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));

        Invitation newInvitation = new Invitation();
        newInvitation.setHost(host);
        newInvitation.setGuest(guest.toEntity());
        newInvitation.setRoom(room);
        invitationRepository.save(newInvitation);

        return new InvitationDto(newInvitation);
    }
}

package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.*;
import com.example.meetingroombooking.model.entity.Booking;
import com.example.meetingroombooking.model.entity.Invitation;
import com.example.meetingroombooking.model.entity.Room;
import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.repository.BookingRepository;
import com.example.meetingroombooking.repository.InvitationRepository;
import com.example.meetingroombooking.repository.RoomRepository;
import com.example.meetingroombooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final RoomRepository roomRepository;
    private final InvitationRepository invitationRepository;
    private final BookingRepository bookingRepository;

    private static final String ROOM_NOT_FOUND = "Room does not exist";
    private static final String USER_NOT_FOUND = "Authenticated user does not exist";

    @Autowired
    public RoomService(UserRepository userRepository, RoomRepository roomRepository, UserService userService,
                       InvitationRepository invitationRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.userService = userService;
        this.invitationRepository = invitationRepository;
        this.bookingRepository = bookingRepository;
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

    @Transactional
    public RoomDto updateRoom(Long id, RoomDto newRoomDto) {
        Room newRoom = new Room();
        newRoom.setId(id);
        newRoom.setCapacity(newRoomDto.getCapacity());
        roomRepository.save(newRoom);

        return newRoomDto;
    }

    @Transactional
    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException(ROOM_NOT_FOUND));
        roomRepository.delete(room);
    }

    @Transactional
    public InvitationDto createInvitation(Long roomId, UserDto guest) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException(ROOM_NOT_FOUND));
        User host = userService.getCurrentUser()
                .orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));

        Invitation newInvitation = new Invitation();
        newInvitation.setHost(host);
        User guestUser = userRepository.findByUsername(guest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        newInvitation.setGuest(guestUser);
        newInvitation.setRoom(room);
        invitationRepository.save(newInvitation);

        return new InvitationDto(newInvitation);
    }

    @Transactional
    public BookingDto createBooking(Long roomId, Dates dates) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException(ROOM_NOT_FOUND));
        User user = userService.getCurrentUser().orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));
        Booking newBooking = new Booking();

        newBooking.setRoom(room);
        newBooking.setUser(user);
        newBooking.setStartingDate(dates.getStarting());
        newBooking.setEndingDate(dates.getEnding());
        bookingRepository.save(newBooking);

        return new BookingDto(newBooking);
    }
}

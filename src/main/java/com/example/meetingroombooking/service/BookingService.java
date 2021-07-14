package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.BookingDto;
import com.example.meetingroombooking.model.entity.Booking;
import com.example.meetingroombooking.model.entity.User;
import com.example.meetingroombooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final UserService userService;
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(UserService userService, BookingRepository bookingRepository) {
        this.userService = userService;
        this.bookingRepository = bookingRepository;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();

        List<BookingDto> result = new ArrayList<>();

        for(Booking booking : bookings) {
            result.add(new BookingDto(booking));
        }

        return result;
    }

    public void abortBooking(Long id) {
        User user = getUser();
        Booking booking = bookingRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Booking does not exist")
        );

        if(booking.getUser().getId().equals(user.getId())) {
            bookingRepository.delete(booking);
        } else {
            throw new RuntimeException("You can't remove this booking");
        }
    }

    private User getUser() {
        Optional<User> user = userService.getCurrentUser();
        return userService.getCurrentUser().orElseThrow(() -> new RuntimeException("User does not exist"));
    }
}
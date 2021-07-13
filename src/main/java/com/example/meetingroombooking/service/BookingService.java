package com.example.meetingroombooking.service;

import com.example.meetingroombooking.model.dto.BookingDto;
import com.example.meetingroombooking.model.entity.Booking;
import com.example.meetingroombooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
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
}
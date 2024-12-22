package com.booking.Booking.service;

import com.booking.Booking.model.Booking;
import com.booking.Booking.model.Room;
import com.booking.Booking.repository.BookingRepository;
import com.booking.Booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepo;

    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    public List<Booking> getBookingByUserUsername(String username) {
        return bookingRepo.findBookingByUserUsername(username);
    }

    public Booking createBooking(LocalDate currentDate, Long hotelId, String userUsername, LocalDate startDate, LocalDate endDate, double totalPrice){
        return bookingRepo.save(new Booking(currentDate,hotelId, userUsername, startDate, endDate,totalPrice))        ;
    }
}

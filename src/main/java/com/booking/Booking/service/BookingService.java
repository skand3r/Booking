package com.booking.Booking.service;

import com.booking.Booking.model.Booking;
import com.booking.Booking.model.Room;
import com.booking.Booking.repository.BookingRepository;
import com.booking.Booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepo;
    @Autowired
    HotelRepository hotelRepo;

    public List<Booking> getAllBookings(){
        return bookingRepo.getAllBookings();
    }

    public String createBooking(Booking booking){
        System.out.println("Booking Room ID: " + booking.getRoomId());

        Room room = hotelRepo.getAllHotels().stream().flatMap(hotel -> hotel.getRoomList().stream()).filter(r -> r.getRoomId().equals(booking.getRoomId())).findFirst().orElse(null);

        if (room == null) {
            return "Room not found with ID: " + booking.getRoomId();
        }

        if (booking.getCheckOutDate().isBefore(booking.getCheckInDate())) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }
        long days = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
        booking.setTotalPrice(days * room.getPricePerNight());
        bookingRepo.saveBooking(booking);
        return "Booking Successful";
    }
}

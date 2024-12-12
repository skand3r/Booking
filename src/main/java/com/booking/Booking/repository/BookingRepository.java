package com.booking.Booking.repository;

import com.booking.Booking.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {

    List<Booking> bookings = new ArrayList<>();

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public void saveBooking(Booking booking){
        bookings.add(booking);
    }
}

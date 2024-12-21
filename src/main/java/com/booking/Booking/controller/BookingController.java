package com.booking.Booking.controller;

import com.booking.Booking.model.Booking;
import com.booking.Booking.model.Hotel;
import com.booking.Booking.service.BookingService;
import com.booking.Booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    HotelService hotelService;

    @GetMapping("/my-booking")
    public String getMyBookings(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
            List<Booking> bookings = bookingService.getBookingByUserUsername(authentication.getName());
            Map<Long, String> hotelNames = bookings.stream()
                    .collect(Collectors.toMap(
                            Booking::getId,
                            booking -> {
                                Hotel hotel = hotelService.findHotelById(booking.getHotelId());
                                return (hotel != null) ? hotel.getName() : "Unknown Hotel";
                            }
                    ));

            model.addAttribute("bookings", bookings);
            model.addAttribute("hotelNames", hotelNames);
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "booking-list";
    }

}

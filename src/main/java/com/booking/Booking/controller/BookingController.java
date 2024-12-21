package com.booking.Booking.controller;

import com.booking.Booking.model.Booking;
import com.booking.Booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/my-booking")
    public String getMyBookings(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
            model.addAttribute("bookings", bookingService.getBookingByUserUsername(authentication.getName()));
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "booking-list";
    }

}

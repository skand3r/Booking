//package com.booking.Booking.controller;
//
//import com.booking.Booking.model.Booking;
//import com.booking.Booking.service.BookingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping
//public class BookingController {
//
//    @Autowired
//    BookingService bookingService;
//
//    @GetMapping("/bookings")
//    public List<Booking> getAllBookings() {
//        return bookingService.getAllBookings();
//    }
//
//    @PostMapping("/bookings")
//    public String createBooking(@RequestBody Booking booking){
//        return bookingService.createBooking(booking);
//    }
//
//}

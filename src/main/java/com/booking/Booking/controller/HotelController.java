package com.booking.Booking.controller;

import com.booking.Booking.model.Booking;
import com.booking.Booking.service.BookingService;
import com.booking.Booking.service.HotelService;
import com.booking.Booking.model.Hotel;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    BookingService bookingService;

    @GetMapping("/hotel")
    public String hotelMain(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "hotel";
    }

    @GetMapping("/hotel/all")
    public String getAllHotels(Authentication authentication, Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        if (authentication != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "hotelresults";
    }

    @GetMapping("/hotel/search/location")
    public String searchHotelsByLocation(@RequestParam String location, Model model, Authentication authentication){
        model.addAttribute("hotels", hotelService.searchHotelsByLocation(location));
        if (authentication != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "hotelresults";
    }

//    @GetMapping("/hotel/{id}/image")
//    public ResponseEntity<byte[]> getImageByHotelId(@PathVariable Long id){
//        Hotel hotel = hotelService.findHotelById(id);
//        if (hotel == null || hotel.getImageURL() == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(hotel.getImageData(), HttpStatus.OK);
//    }

    @PostMapping("/hotel/add")
    public ResponseEntity<?> addHotel(@RequestPart Hotel hotel, @RequestPart MultipartFile image, HttpServletRequest request){
        Hotel savedHotel = null;
        try {
            savedHotel = hotelService.addHotel(hotel,image);
            return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("hotel/{id}/book")
    public String getHotelBookingPage(@PathVariable Long id, Model model, Authentication authentication) {
        Hotel hotel = hotelService.findHotelById(id);
        model.addAttribute("hotel", hotel);
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        model.addAttribute("currentDate", currentDate);
        // Authentication
        if (authentication != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "hotel-booking-page";

    }
    @PostMapping("hotel/{id}/book")
    public String bookHotel(@PathVariable Long id, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate , Model model, Authentication authentication){


        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            model.addAttribute("isAuthenticated", false);
            model.addAttribute("notSignedInError", "You need to sign in before booking!");
            Hotel hotel = hotelService.findHotelById(id);
            model.addAttribute("hotel", hotel);
            return "hotel-booking-page";
        }
        else if (startDate.equals(endDate)) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
            model.addAttribute("sameDayError", "Invalid Dates!");
            Hotel hotel = hotelService.findHotelById(id);
            model.addAttribute("hotel", hotel);
            return "hotel-booking-page";
        }
        else {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
            int nightsStay = (int) ChronoUnit.DAYS.between(startDate, endDate);
            Hotel hotel = hotelService.findHotelById(id);
            double totalPrice = hotelService.calculateTotalPrice(hotel, nightsStay);

            Booking booking = bookingService.createBooking(LocalDate.now(), id, authentication.getName(), startDate, endDate, totalPrice);

            model.addAttribute("numberOfNights", nightsStay);
            model.addAttribute("booking", booking);


            return "booking-successful";
        }

    }





}

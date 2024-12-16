package com.booking.Booking.controller;

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
import java.util.List;
import java.util.Optional;

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;

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
    public String getAllHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotelresults";
    }

    @GetMapping("/hotel/search/location")
    public String searchHotelsByLocation(@RequestParam String location, Model model){
        System.out.println(location);
        model.addAttribute("hotels", hotelService.searchHotelsByLocation(location));
        return "hotelresults";
    }

    @GetMapping("/hotel/{id}/image")
    public ResponseEntity<byte[]> getImageByHotelId(@PathVariable Long id){
        Hotel hotel = hotelService.findHotelById(id);
        if (hotel == null || hotel.getImageData() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotel.getImageData(), HttpStatus.OK);
    }

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





}

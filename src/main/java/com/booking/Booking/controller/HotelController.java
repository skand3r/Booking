package com.booking.Booking.controller;

import com.booking.Booking.service.HotelService;
import com.booking.Booking.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping("/hotel/search/price/{maxPrice}")
    public List<Hotel> searchHotelsByPrice(@PathVariable double maxPrice){
        return hotelService.searchHotelRoomsByPrice(maxPrice);
    }


}

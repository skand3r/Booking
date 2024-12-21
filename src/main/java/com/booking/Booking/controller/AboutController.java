package com.booking.Booking.controller;

import com.booking.Booking.model.Hotel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {


    @GetMapping("/about")
    public String getAbout(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "about";
    }

}

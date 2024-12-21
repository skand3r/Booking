package com.booking.Booking.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignInController {

    @GetMapping("/login")
    public String signIn(@RequestParam(value = "error", required = false) String error, Model model) {

        if (error != null) {
            model.addAttribute("errorLogin", "Invalid Username or Password");
        }
        return "login";
    }

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "index";
    }


    @GetMapping("/debug")
    @ResponseBody
    public String debug(Authentication authentication) {
        if (authentication == null) {
            return "No authentication context found";
        }
        return "Authenticated as: " + authentication.getName();
    }




}

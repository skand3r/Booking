package com.booking.Booking.controller;

import com.booking.Booking.model.User;
import com.booking.Booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signUpPage(){
        return "signup";
    }


    @PostMapping("/signup")
    public String signUp(@RequestParam String username,@RequestParam String firstName, @RequestParam String lastName,@RequestParam String email,@RequestParam String password, Model model){
        if (userService.userExistsUsername(username)) {
            model.addAttribute("error", "Username is taken");
            return "signup";
        }
        if (userService.userExistsEmail(email)) {
            model.addAttribute("error_2", "Email is already in use");
            return "signup";
        }
        userService.addUser(new User(username,firstName, lastName, email, password));
        model.addAttribute("success" , "Sign up successful. You can login now");
        return "signup";
    }


    @GetMapping("/userslist")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


}

package com.booking.Booking.service;

import com.booking.Booking.model.User;
import com.booking.Booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public boolean userExistsUsername(String username) {
        return userRepo.findByUsername(username) != null;
    }
    public boolean userExistsEmail(String email) {
        return userRepo.findByEmail(email) != null;
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }
}

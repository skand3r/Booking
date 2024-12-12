package com.booking.Booking.service;

import com.booking.Booking.model.User;
import com.booking.Booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void addUser(User user) {
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

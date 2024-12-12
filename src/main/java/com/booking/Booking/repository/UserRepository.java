package com.booking.Booking.repository;

import com.booking.Booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    User findByEmail(String email);

//    List<User> users = new ArrayList<>();
//
//    public List<User> getAllUsers() {
//        return users;
//    }
//
//    public void addUser (User user) {
//        users.add(user);
//    }
}

package com.booking.Booking.repository;

import com.booking.Booking.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {
    List<Room> rooms = new ArrayList<>();

    public RoomRepository() {
        rooms.add(new Room(100l, "Single", 30.0, null));
        rooms.add(new Room(101l, "Double", 50.0, null));
        rooms.add(new Room(102l, "Suite", 90.0, null));
    }


    public List<Room> getAllRooms() {
        return rooms;
    }
}

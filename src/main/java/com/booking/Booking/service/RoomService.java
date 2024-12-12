package com.booking.Booking.service;

import com.booking.Booking.model.Room;
import com.booking.Booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.getAllRooms();
    }

    public List<Room> searchRoomById(long id){
        return roomRepository.getAllRooms().stream().filter(room -> room.getRoomId() == id).toList();
    }

    public List<Room> searchRoomByType(String... types){
        return roomRepository.getAllRooms().stream().filter(room -> Arrays.asList(types).contains(room.getType())).toList();
    }
}

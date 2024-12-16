package com.booking.Booking.repository;

import com.booking.Booking.model.Hotel;
import com.booking.Booking.model.Room;
import com.booking.Booking.service.RoomService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel findHotelById(Long id);
//    List<Hotel> hotels = new ArrayList<>();
//
//    @Autowired
//    RoomRepository roomRepository;
//
//    @PostConstruct
//    public void init() {
//        List<Room> rooms = roomRepository.getAllRooms();
//        // Hotels in Berlin
//        hotels.add(new Hotel(1000L, "Winter Hotel", "Berlin", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/WinterHotel.jpg"));
//        hotels.add(new Hotel(1001L, "Berlin Grand Palace", "Berlin", List.of(rooms.get(0), rooms.get(1)), "/hotel-images/BerlinGrandPalace.jpeg"));
//        hotels.add(new Hotel(1002L, "Checkpoint Suites", "Berlin", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/CheckpointSuites.jpg"));
//
//        // Hotels in London
//        hotels.add(new Hotel(1003L, "Palm Grove", "London", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/PalmGrove.jpg"));
//        hotels.add(new Hotel(1004L, "Royal Crescent Inn", "London", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/RoyalCrescentInn.jpg"));
//        hotels.add(new Hotel(1005L, "Thames View Hotel", "London", List.of(rooms.get(0), rooms.get(1)), "/hotel-images/ThamesViewHotel.jpg"));
//
//        // Hotels in Sydney
//        hotels.add(new Hotel(1006L, "Ocean Breeze", "Sydney", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/OceanBreeze.jpg"));
//        hotels.add(new Hotel(1007L, "Harbour Luxe Retreat", "Sydney", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/HarbourLuxeRetreat.jpg"));
//        hotels.add(new Hotel(1008L, "Kangaroo Bay Hotel", "Sydney", List.of(rooms.get(0), rooms.get(1)), "/hotel-images/KangarooBayHotel.jpeg"));
//
//        // Hotels in Tokyo
//        hotels.add(new Hotel(1009L, "Starlight Hotel", "Tokyo", List.of(rooms.get(0), rooms.get(1)), "/hotel-images/StarlightHotel.jpeg"));
//        hotels.add(new Hotel(1010L, "Tokyo Sky Haven", "Tokyo", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/TokyoSkyHaven.jpg"));
//        hotels.add(new Hotel(1011L, "Shinjuku Serenity", "Tokyo", List.of(rooms.get(0), rooms.get(1)), "/hotel-images/ShinjukuSerenity.jpg"));
//
//        // Hotels in Dubai
//        hotels.add(new Hotel(1012L, "Golden Sands", "Dubai", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/GoldenSands.jpg"));
//        hotels.add(new Hotel(1013L, "Desert Oasis Resort", "Dubai", List.of(rooms.get(0), rooms.get(1), rooms.get(2)), "/hotel-images/DesertOasisResort.jpg"));
//        hotels.add(new Hotel(1014L, "Burj View Suites", "Dubai", List.of(rooms.get(2)), "/hotel-images/BurjViewSuites.jpg"));
//    }
//
//    public List<Hotel> getAllHotels() {
//        return hotels;
//    }


}

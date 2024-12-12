package com.booking.Booking.service;

import com.booking.Booking.model.Hotel;
import com.booking.Booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepo;

    public List<Hotel> getAllHotels() {
        return hotelRepo.getAllHotels();
    }

    // get List of Hotels by Location
    public List<Hotel> searchHotelsByLocation(String location) {
        return hotelRepo.getAllHotels().stream().filter(hotel -> hotel.getLocation().equalsIgnoreCase(location)).toList();
    }

    // get List of Hotels by Price
    public List<Hotel> searchHotelRoomsByPrice(double maxPrice) {
        return hotelRepo.getAllHotels().stream().filter(hotel -> hotel.getRoomList().stream().anyMatch(room -> room.getPricePerNight() <= maxPrice)).toList();
    }
}

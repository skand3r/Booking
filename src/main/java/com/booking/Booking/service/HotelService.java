package com.booking.Booking.service;

import com.booking.Booking.model.Hotel;
import com.booking.Booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepo;

    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    // get List of Hotels by Location
    public List<Hotel> searchHotelsByLocation(String location) {
        return hotelRepo.findAll().stream().filter(hotel -> hotel.getLocation().equalsIgnoreCase(location)).toList();
    }


    public Hotel findHotelById (Long id){
        return hotelRepo.findHotelById(id);
    }

//    // get List of Hotels by Price
//    public List<Hotel> searchHotelRoomsByPrice(double maxPrice) {
//        return hotelRepo.findAll().stream().filter(hotel -> hotel.getRoomList().stream().anyMatch(room -> room.getPricePerNight() <= maxPrice)).toList();
//    }

    public Hotel addHotel(Hotel hotel, MultipartFile image) throws IOException {
        hotel.setImageData(image.getBytes());

        return hotelRepo.save(hotel);
    }
}

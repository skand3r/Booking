package com.booking.Booking.service;

import com.booking.Booking.model.Hotel;
import com.booking.Booking.model.User;
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
        List<Hotel> hotels = hotelRepo.findAll();
        for (Hotel hotel : hotels) {
            // Assuming imageUrl is stored directly in the database
            if (hotel.getImageUrl() == null || hotel.getImageUrl().isEmpty()) {
                hotel.setImageUrl("https://ztmibqzflhinqosjjbak.supabase.co/storage/v1/object/sign/hotel-images/BurjViewSuites.jpg?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJob3RlbC1pbWFnZXMvQnVyalZpZXdTdWl0ZXMuanBnIiwiaWF0IjoxNzM0NjU4NDM2LCJleHAiOjE4OTIzMzg0MzZ9.505XiRKxdPJoe0rzop_m3weo6r-aL--UBHcp_he-1_Q&t=2024-12-20T01%3A33%3A57.062Z"); // Fallback image
            }
        }
        return hotels;
    }


    public List<Hotel> searchHotelsByLocation(String location) {
        return hotelRepo.findHotelByLocationIgnoreCase(location);
    }


    public Hotel findHotelById (Long id){
        return hotelRepo.findHotelById(id);
    }

//    // get List of Hotels by Price
//    public List<Hotel> searchHotelRoomsByPrice(double maxPrice) {
//        return hotelRepo.findAll().stream().filter(hotel -> hotel.getRoomList().stream().anyMatch(room -> room.getPricePerNight() <= maxPrice)).toList();
//    }

    public Hotel addHotel(Hotel hotel, MultipartFile image) throws IOException {
//        hotel.setImageData(image.getBytes());

        return hotelRepo.save(hotel);
    }

    public double calculateTotalPrice(Hotel hotel, int numberOfNights) {
        return hotel.getPricePerNight() * numberOfNights;
    }
}

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

    List<Hotel> findHotelByLocationIgnoreCase(String location);

}

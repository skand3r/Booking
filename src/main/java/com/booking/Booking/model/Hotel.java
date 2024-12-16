package com.booking.Booking.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class Hotel {
    @Id
    private Long id;
    private String name;
    private String location;
//    private List<Room> roomList = new ArrayList<>();
//    private String imageName;
//    private String imageType;
    private Double pricePerNight;
    @Lob
    private byte[] imageData;
}

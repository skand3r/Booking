package com.booking.Booking.model;


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
public class Hotel {
    private Long id;
    private String name;
    private String location;
    private List<Room> roomList = new ArrayList<>();
    private String imageUrl;
}

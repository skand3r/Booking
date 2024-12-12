package com.booking.Booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Room {
    private Long roomId;
    private String type;
    private Double pricePerNight;
    private Boolean isAvailabe;
}

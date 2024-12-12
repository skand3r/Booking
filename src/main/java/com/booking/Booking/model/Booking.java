package com.booking.Booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Booking {
    private Long id;
    private Long userId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long roomId;
    private Double totalPrice;
}

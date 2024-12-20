package com.booking.Booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Long hotelId;
    @NonNull
    private String userUsername;
    @NonNull
    private LocalDate checkInDate;
    @NonNull
    private LocalDate checkOutDate;
    @NonNull
    private Double totalPrice;
}

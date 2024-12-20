package com.booking.Booking.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
    private Double pricePerNight;
    @Column(name = "imageurl", columnDefinition = "TEXT")
    private String imageUrl;
}

package com.example.easy_book.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hotelId;
    private int roomNumber;
    private String roomType;
    private BigDecimal pricePerNight;
    private int capacity;
    private String amenities;
    private boolean isAvailable;
}

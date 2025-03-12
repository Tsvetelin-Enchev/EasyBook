package com.example.easy_book.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long hotelId;
    private Long roomId;
    private Date checkInDate;
    private Date checkOutDate;
    private BigDecimal totalPrice;
    private String status;
}

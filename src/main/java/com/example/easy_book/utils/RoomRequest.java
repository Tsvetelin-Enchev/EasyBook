package com.example.easy_book.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    private String hotelName;
    private String hotelAddress;
    private int roomNumber;
    private String roomType;
    private BigDecimal pricePerNight;
    private int capacity;
    private String amenities;
}

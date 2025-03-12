package com.example.easy_book.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterHotelRequest {
    String name;
    String address;
    String city;
    String country;
    String description;
    String phone;
    String email;
}

package com.example.easy_book.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String name;
    private String address;
    private String city;
    private String country;
    private Double rating;
    private String description;
    private String phone;
    private String email;
}

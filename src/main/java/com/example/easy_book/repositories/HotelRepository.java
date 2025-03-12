package com.example.easy_book.repositories;

import com.example.easy_book.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByOwner(String owner);
    Optional<Hotel> findByName(String name);
    Optional<Hotel> findByCountry(String country);
    Optional<Hotel> findByCity(String city);
    Optional<Hotel> findByAddress(String address);
    Hotel findByOwnerAndAddress(String owner, String address);
    Optional<Hotel> findByNameAndCityAndAddress(String name, String city, String address);
    Hotel findByNameAndAddress(String name, String address);
}

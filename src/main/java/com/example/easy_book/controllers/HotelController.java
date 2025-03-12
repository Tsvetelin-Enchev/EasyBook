package com.example.easy_book.controllers;

import com.example.easy_book.services.HotelService;
import com.example.easy_book.utils.RegisterHotelRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PreAuthorize("hasRole('HOTELIER')")
    @PostMapping("/create")
    public String createNewHotel(@RequestBody RegisterHotelRequest request) {
        hotelService.createHotel(request);
        return "Hotel registered successfully!";
    }

    @PreAuthorize("hasAnyRole('USER','HOTELIER')")
    @GetMapping("/show/all")
    public String getAllHotels() {
        //TODO Create more user-friendly output
        return hotelService.getAllHotels().toString();
    }

    //TODO Create method to filter all hotels from a specific country
    //TODO Create method to filter all hotels from a specific city
}

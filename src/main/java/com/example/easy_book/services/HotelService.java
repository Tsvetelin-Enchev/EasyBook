package com.example.easy_book.services;

import com.example.easy_book.common.Validation;
import com.example.easy_book.entities.Hotel;
import com.example.easy_book.entities.User;
import com.example.easy_book.repositories.HotelRepository;
import com.example.easy_book.utils.RegisterHotelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final UserService userService;
    private final Validation validation;

    @Autowired
    public HotelService(HotelRepository hotelRepository, UserService userService, Validation validation) {
        this.hotelRepository = hotelRepository;
        this.userService = userService;
        this.validation = validation;
    }

    public void createHotel(RegisterHotelRequest request) {
        validation.checkIfHotelAlreadyExist(request.getName(), request.getCity(), request.getAddress());
        User user = userService.getCurrentLoggedUser();
        Hotel hotel = implementHotel(request, user.getUsername());
        hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    private Hotel implementHotel(RegisterHotelRequest request, String username) {
        Hotel hotel = new Hotel();

        hotel.setOwner(username);
        hotel.setName(request.getName());
        hotel.setAddress(request.getAddress());
        hotel.setCity(request.getCity());
        hotel.setCountry(request.getCountry());
        hotel.setRating(0.0);
        hotel.setDescription(request.getDescription());
        hotel.setPhone(request.getPhone());
        hotel.setEmail(request.getEmail());

        return hotel;
    }
    //TODO Create method to filter all hotels from a specific country
    //TODO Create method to filter all hotels from a specific city
}


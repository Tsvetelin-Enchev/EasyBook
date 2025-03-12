package com.example.easy_book.services;

import com.example.easy_book.common.Validation;
import com.example.easy_book.entities.Hotel;
import com.example.easy_book.entities.Room;
import com.example.easy_book.entities.User;
import com.example.easy_book.repositories.HotelRepository;
import com.example.easy_book.repositories.RoomRepository;
import com.example.easy_book.utils.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final UserService userService;
    private final Validation validation;

    @Autowired
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository, UserService userService, Validation validation) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.userService = userService;
        this.validation = validation;
    }

    public void addNewRoom(RoomRequest request) {
        User user = userService.getCurrentLoggedUser();
        Hotel hotel = validation.checkIfHotelExist(user.getUsername(), request.getHotelAddress());
        validation.checkIfRoomNumberAlreadyExist(hotel.getId(), request.getRoomNumber());

        Room room = implementRoom(hotel.getId(), request);

        roomRepository.save(room);
    }

    public void updateRoomPrice(String hotelName, String hotelAddress, int roomNumber, BigDecimal price) {
        Hotel hotel = hotelRepository.findByNameAndAddress(hotelName, hotelAddress);
        Room room = roomRepository.findByHotelIdAndRoomNumber(hotel.getId(), roomNumber);
        room.setPricePerNight(price);
        roomRepository.save(room);
    }

    public void updateRoomStatus(String hotelName, String hotelAddress, int roomNumber, boolean availableStatus) {
        Hotel hotel = hotelRepository.findByNameAndAddress(hotelName, hotelAddress);
        Room room = roomRepository.findByHotelIdAndRoomNumber(hotel.getId(), roomNumber);
        room.setAvailable(availableStatus);
        roomRepository.save(room);
    }

    private Room implementRoom(Long hotelId, RoomRequest request) {
        Room room = new Room();

        room.setHotelId(hotelId);
        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setPricePerNight(request.getPricePerNight());
        room.setCapacity(request.getCapacity());
        room.setAmenities(request.getAmenities());
        room.setAvailable(true);

        return room;
    }

    //TODO Create method to book room
    //TODO Create method to get all rooms
}

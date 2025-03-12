package com.example.easy_book.common;

import com.example.easy_book.entities.Hotel;
import com.example.easy_book.entities.Room;
import com.example.easy_book.exceptions.InvalidException;
import com.example.easy_book.repositories.HotelRepository;
import com.example.easy_book.repositories.RoomRepository;
import com.example.easy_book.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.easy_book.common.ExceptionMessages.*;

@Component
public class Validation{

    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public Validation(UserRepository userRepository, HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    public void checkIfUsernameExists(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new InvalidException(USERNAME_ALREADY_EXIST);
        }
    }

    public void checkIfEmailExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new InvalidException(EMAIL_ALREADY_EXIST);
        }
    }

    public void checkIfHotelAlreadyExist(String name, String city, String address) {
        if (hotelRepository.findByNameAndCityAndAddress(name, city, address).isPresent()) {
            throw new InvalidException(HOTEL_ALREADY_EXIST);
        }
    }

    public Hotel checkIfHotelExist(String username, String hotelAddress) {
        Hotel hotel = hotelRepository.findByOwnerAndAddress(username, hotelAddress);
        if (hotel == null) {
            throw new InvalidException(INVALID_HOTEL);
        }
        return hotel;
    }

    public void checkIfRoomNumberAlreadyExist(Long hotelId, int roomNumber) {
        List<Room> rooms = roomRepository.findAllByHotelId(hotelId);

        rooms.forEach(room -> {
            if (room.getRoomNumber() == roomNumber) {
                throw new InvalidException(ROOM_ALREADY_EXIST);
            }
        });
    }
}

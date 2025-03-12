package com.example.easy_book.repositories;

import com.example.easy_book.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByHotelId(Long hotelId);
    Room findByRoomNumber(int roomNumber);
    Room findByHotelIdAndRoomNumber(Long id, int roomNumber);
}

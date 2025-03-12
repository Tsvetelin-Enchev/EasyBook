package com.example.easy_book.controllers;

import com.example.easy_book.services.RoomService;
import com.example.easy_book.utils.RoomRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PreAuthorize("hasRole('HOTELIER')")
    @PostMapping("/add")
    public String addRoom(@RequestBody RoomRequest request) {
        roomService.addNewRoom(request);
        return "Room added successfully!";
    }

    @PreAuthorize("hasRole('HOTELIER')")
    @PutMapping("/update/price")
    public String updateRoomPrice(@RequestParam String hotelName,
                                  @RequestParam String hotelAddress,
                                  @RequestParam int roomNumber,
                                  @RequestParam BigDecimal price) {
        roomService.updateRoomPrice(hotelName, hotelAddress, roomNumber, price);
        return "Room price updated successfully!";
    }

    @PreAuthorize("hasRole('HOTELIER')")
    @PutMapping("/update/status")
    public String updateRoomStatus(@RequestParam String hotelName,
                                  @RequestParam String hotelAddress,
                                  @RequestParam int roomNumber,
                                  @RequestParam boolean availableStatus) {
        roomService.updateRoomStatus(hotelName, hotelAddress, roomNumber, availableStatus);
        return "Room status updated successfully!";
    }

    //TODO Create method to book room
    //TODO Create method to get all rooms
}

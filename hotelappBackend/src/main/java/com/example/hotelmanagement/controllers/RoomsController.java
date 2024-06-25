package com.example.hotelmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.hotelmanagement.entities.Rooms;
import com.example.hotelmanagement.services.RoomsService;

@RestController
public class RoomsController {
    
    @Autowired
    RoomsService roomsService;

    @GetMapping("getAllRooms")
    public List<Rooms> getAllRooms(){
        return roomsService.getAllRooms();
    }

    @GetMapping("getSingleRoom/{id}")
    public Rooms getRoomDetails(@PathVariable Long id){
        return roomsService.getRoomDetails(id);
    }

    @PostMapping("createRoom")
    public String createRoom(@RequestBody Rooms room){
        return roomsService.createRoom(room);
    }

    @DeleteMapping("deleteRoom/{id}")
    public String deleteRoom(@PathVariable Long id){
        if(roomsService.deleteRooms(id)){
            return "Room deleted successfully";
        }else{
            return "Room Not Found!";
        }
    }

    @PutMapping("updateRoom/{id}")
    public String updateRoom(@PathVariable Long id, @RequestBody Rooms room){
        return roomsService.updateRoom(id, room);
    }
}

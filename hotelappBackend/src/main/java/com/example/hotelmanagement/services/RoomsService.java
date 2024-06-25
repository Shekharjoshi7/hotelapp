package com.example.hotelmanagement.services;

import java.util.List;

import com.example.hotelmanagement.entities.Rooms;

public interface RoomsService {
     String createRoom(Rooms rooms);
     List<Rooms> getAllRooms();
     Rooms getRoomDetails(Long roomId);
     boolean deleteRooms(Long roomId);
     String updateRoom(Long roomId, Rooms rooms);

}

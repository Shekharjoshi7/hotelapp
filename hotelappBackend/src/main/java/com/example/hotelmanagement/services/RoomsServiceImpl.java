package com.example.hotelmanagement.services;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotelmanagement.entities.Rooms;
import com.example.hotelmanagement.entities.RoomsEntity;
import com.example.hotelmanagement.repositories.RoomsRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoomsServiceImpl implements RoomsService {
    
    @Autowired
    private RoomsRepository roomsRepo;

    @Override
    public String createRoom(Rooms rooms){
        RoomsEntity roomsEntity = new RoomsEntity();
        roomsEntity.setRoomId(rooms.getRoomId());
        roomsEntity.setRoomType(rooms.getRoomType());
        roomsEntity.setBooked(rooms.isBooked());
        roomsEntity.setPrice(rooms.getPrice());
        roomsRepo.save(roomsEntity);
        return "Room created";
    }

    @Override
    public List<Rooms> getAllRooms(){
        List<RoomsEntity> roomEntity = roomsRepo.findAll();
        List<Rooms> room = new ArrayList<>();
        for(RoomsEntity rm : roomEntity){
            Rooms r = new Rooms();
            r.setRoomId(rm.getRoomId());
            r.setRoomType(rm.getRoomType());
            r.setBooked(rm.isBooked());
            r.setPrice(rm.getPrice());
            room.add(r);
        }
        return room;
    }

    @Override
    public Rooms getRoomDetails(Long roomId){
        Optional<RoomsEntity> roomEnt = roomsRepo.findById(roomId);
        Rooms room = new Rooms();
        if(roomEnt.isPresent()){   
            RoomsEntity roomE = roomEnt.get();
            BeanUtils.copyProperties(roomE, room);
            return room;
        }else{
            return null;
        }
    }

    @Override
    public boolean deleteRooms(Long roomId){
        Optional<RoomsEntity> roomEnt = roomsRepo.findById(roomId);
        if(roomEnt.isPresent()){
            RoomsEntity room = roomEnt.get();
            roomsRepo.delete(room);
            return true;
        }else{   
            return false;
        }

    }

    @Override
    public String updateRoom(Long roomId, Rooms rooms){
        Optional<RoomsEntity> roomEnt = roomsRepo.findById(roomId);
        if(roomEnt.isPresent()){
            RoomsEntity room = roomEnt.get();
            room.setBooked(!room.isBooked());
            roomsRepo.save(room);
            return "Room Updated successfully";
        }else{   
            return "Room Not Found";
        }
    }
}


package com.example.hotelmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelmanagement.entities.RoomsEntity;

@Repository
public interface RoomsRepository extends JpaRepository<RoomsEntity, Long>{

    
}

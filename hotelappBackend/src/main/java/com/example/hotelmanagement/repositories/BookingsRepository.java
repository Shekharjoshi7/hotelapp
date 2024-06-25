package com.example.hotelmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelmanagement.entities.BookingsEntity;

@Repository
public interface BookingsRepository extends JpaRepository<BookingsEntity, Long>{
    
}

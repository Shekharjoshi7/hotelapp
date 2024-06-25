package com.example.hotelmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rooms")
public class RoomsEntity {
    @Id
    private Long roomId;
    private String roomType;
    private boolean isBooked;
    private int price;
}

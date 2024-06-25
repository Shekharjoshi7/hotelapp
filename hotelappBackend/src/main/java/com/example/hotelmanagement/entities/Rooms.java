package com.example.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rooms {
    private Long roomId;
    private String roomType;
    private boolean isBooked;
    private int price;
}

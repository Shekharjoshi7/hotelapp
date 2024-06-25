package com.example.hotelmanagement.entities;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookings {
    private Long bookingId;
    private Long customer_id;
    private Long room_id;
    private Date checkInDate;
    private Date checkOutDate;
}

package com.example.hotelmanagement.services;

import java.util.*;

import com.example.hotelmanagement.entities.Bookings;
public interface BookingsService {
    String createBooking(Bookings bookings );
    List<Bookings> readBookings();
    Bookings readBooking(Long bookingId);
    boolean deleteBooking(Long bookingId);
}

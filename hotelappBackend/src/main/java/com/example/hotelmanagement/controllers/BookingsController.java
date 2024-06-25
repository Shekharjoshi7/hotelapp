package com.example.hotelmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.hotelmanagement.entities.Bookings;
import com.example.hotelmanagement.services.BookingsService;

@RestController
public class BookingsController {
    @Autowired
    BookingsService bookingsService;

    @PostMapping("createBooking")
    public String createBooking(@RequestBody Bookings booking){
        return bookingsService.createBooking(booking);
    }

    @GetMapping("getBookings")
    public List<Bookings> readBookings(){
       return bookingsService.readBookings();
    }

    @DeleteMapping("deleteBooking/{id}")

    public String deleteBooking(@PathVariable Long id){
        if(bookingsService.deleteBooking(id)){
            return "Booking canceled";
        }else{
            return "Booking not Found!";
        }
    }

    @GetMapping("getBookings/{id}")
    public Bookings getBooking(@PathVariable Long id){
       return bookingsService.readBooking(id);
    }
}

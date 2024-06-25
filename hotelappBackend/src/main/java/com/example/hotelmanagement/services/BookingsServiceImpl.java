package com.example.hotelmanagement.services;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagement.entities.Bookings;
import com.example.hotelmanagement.entities.BookingsEntity; 
import com.example.hotelmanagement.repositories.BookingsRepository;
import com.example.hotelmanagement.repositories.CustomerRepository;
import com.example.hotelmanagement.repositories.RoomsRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookingsServiceImpl implements BookingsService {
    
    @Autowired
    private BookingsRepository bookingRepo;
    
    @Autowired 
    private RoomsRepository roomsRepo;

    @Autowired 
    private CustomerRepository customerRepo;

    @Override
    public String createBooking(Bookings bookings ){
     BookingsEntity bookingEntity = new BookingsEntity();
     bookingEntity.setRoom_id(bookings.getRoom_id());
     bookingEntity.setCustomer_id(bookings.getCustomer_id());
     bookingEntity.setBookingId(bookings.getBookingId());
     bookingEntity.setCheckInDate(bookings.getCheckInDate());
     bookingEntity.setCheckOutDate(bookings.getCheckOutDate());
     bookingRepo.save(bookingEntity);
     return "Saved successful";
    }
    
    @Override
    public List<Bookings> readBookings(){
            List<BookingsEntity> bookingEntities = bookingRepo.findAll();
            List<Bookings> bookingsList = new ArrayList<>();
            for(BookingsEntity b : bookingEntities){
                Bookings booking = new Bookings();
                booking.setBookingId(b.getBookingId());
                booking.setRoom_id(b.getRoom_id());
                booking.setCustomer_id(b.getCustomer_id());
                booking.setCheckInDate(b.getCheckInDate());
                booking.setCheckOutDate(b.getCheckOutDate());
                bookingsList.add(booking);
            }
            return bookingsList;

        }
    @Override
    public Bookings readBooking(Long bookingId){
        BookingsEntity book = bookingRepo.findById(bookingId).get();
        Bookings booking = new Bookings();
        BeanUtils.copyProperties(book, booking);
        return booking;
    }
    @Override
    public boolean deleteBooking(Long bookingId){
        Optional<BookingsEntity> bookingEnt = bookingRepo.findById(bookingId);
        if(bookingEnt.isPresent()){
            BookingsEntity book = bookingEnt.get();
            bookingRepo.delete(book);
            return true;
        }else{
            return false;
        }
    }
}


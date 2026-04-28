package com.tourapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourapp.model.Booking;
import com.tourapp.repository.BookingRepository;
@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;
    /* =========================
       SAVE BOOKING
       ========================= */
    public void saveBooking(Booking booking) {
        repository.save(booking);
    }
    /* =========================
       GET ALL BOOKINGS
       ========================= */
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }
    /* =========================
       DELETE BOOKING
       ========================= */
    public void deleteBooking(int id) {
        repository.deleteById(id);
    }
    /* =========================
       GET BOOKING BY ID
       ========================= */
    public Booking getBookingById(int id) {
        return repository.findById(id).orElse(null);
    }
}
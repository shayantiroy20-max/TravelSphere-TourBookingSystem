package com.tourapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tourapp.model.Booking;
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
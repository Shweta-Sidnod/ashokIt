package com.carrental.CarRental.repositories;

import com.carrental.CarRental.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, String> {
    //List<Booking> findByUserId(Long id);
}

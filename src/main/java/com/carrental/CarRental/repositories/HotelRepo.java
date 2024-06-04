package com.carrental.CarRental.repositories;

import com.carrental.CarRental.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, String> {
}

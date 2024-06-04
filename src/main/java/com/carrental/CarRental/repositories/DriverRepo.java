package com.carrental.CarRental.repositories;

import com.carrental.CarRental.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}

package com.carrental.CarRental.repositories;

import com.carrental.CarRental.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, String> {

}

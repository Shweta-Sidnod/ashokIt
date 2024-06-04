package com.carrental.CarRental.repositories;

import com.carrental.CarRental.entities.AtmCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmCardRepo extends JpaRepository<AtmCard,String> {
}

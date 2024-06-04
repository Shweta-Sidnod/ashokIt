package com.carrental.CarRental.repositories;

import com.carrental.CarRental.entities.FinalConfirm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinalConfirmRepo extends JpaRepository<FinalConfirm, String> {
    public Optional<FinalConfirm>findByEmail(String email);
}

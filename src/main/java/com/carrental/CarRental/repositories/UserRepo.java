package com.carrental.CarRental.repositories;

import com.carrental.CarRental.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

   // Optional<User> findByUsername(String username);

    User findByEmailAndPassword(String email, String password);
}
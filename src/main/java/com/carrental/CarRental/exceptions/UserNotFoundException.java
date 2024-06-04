package com.carrental.CarRental.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("user not found"  +id);
    }
}


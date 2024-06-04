package com.carrental.CarRental.exceptions;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String s){
        super("Booking not Found");
    }
}

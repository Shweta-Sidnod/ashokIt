package com.carrental.CarRental.exceptions;

public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(String id){
        super("No such driver found with id: "+id);
    }
}

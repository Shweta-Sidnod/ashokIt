package com.carrental.CarRental.exceptions;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(String id){
        super("No such car found with id: "+id);
    }
}

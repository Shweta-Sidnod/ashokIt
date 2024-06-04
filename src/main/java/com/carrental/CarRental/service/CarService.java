package com.carrental.CarRental.service;

import com.carrental.CarRental.payloads.CarDto;

import java.util.List;

public interface CarService {

   public CarDto createCar(CarDto carDto);

   List<CarDto> getAllCars();

   public String deleteCar(String id);

List<CarDto> findCarById(String id);

}

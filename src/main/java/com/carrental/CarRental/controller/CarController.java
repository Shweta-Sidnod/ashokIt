package com.carrental.CarRental.controller;

import com.carrental.CarRental.payloads.CarDto;
import com.carrental.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto) {
        CarDto cars = this.carService.createCar(carDto);
        return new ResponseEntity<CarDto>(cars, HttpStatus.CREATED);
    }

    @GetMapping("/allcars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public List<CarDto> findCarById(@PathVariable String id) {
        return carService.findCarById(id);
    }
    @DeleteMapping("/delete/{carId}")
    public ResponseEntity<String> deleteCar(@PathVariable String id){
        String carDto1=this.carService.deleteCar(id);
        return new ResponseEntity<>(carDto1,HttpStatus.OK);
    }
}
package com.carrental.CarRental.service.impl;

import com.carrental.CarRental.entities.Car;
import com.carrental.CarRental.exceptions.CarNotFoundException;
import com.carrental.CarRental.payloads.CarDto;
import com.carrental.CarRental.repositories.CarRepo;
import com.carrental.CarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarDto createCar(CarDto carDto) {
        Car cars=this.modelMapper.map(carDto , Car.class);
        String id= UUID.randomUUID().toString();
        cars.setId(id);
        Car updatedCar=this.carRepo.save(cars);
        CarDto carDto1=this.modelMapper.map(cars , CarDto.class);
        return carDto1;
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepo.findAll().stream().map(e->modelMapper.map(e,CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public String deleteCar(String id) {
        Car cars=carRepo.findById(id).orElseThrow(()->new CarNotFoundException(id));
        carRepo.deleteById(id);
        return "Car Deleted";
    }

    @Override
    public List<CarDto> findCarById(String id) {
        List<CarDto>carDtos=carRepo.findById(id).stream().map(e->modelMapper.map(e,CarDto.class)).collect(Collectors.toList());
        return carDtos;
    }


}

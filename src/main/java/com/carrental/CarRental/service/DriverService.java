package com.carrental.CarRental.service;

import com.carrental.CarRental.payloads.CarDto;
import com.carrental.CarRental.payloads.DriverDto;
import com.carrental.CarRental.payloads.UserDto;

import java.util.List;

public interface DriverService {

    DriverDto createDriver(DriverDto driverDto);


    List<DriverDto> getAllDrivers();


    String deleteDriver(String id);

}

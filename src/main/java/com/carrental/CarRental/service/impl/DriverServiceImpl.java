package com.carrental.CarRental.service.impl;

import com.carrental.CarRental.entities.Driver;
import com.carrental.CarRental.exceptions.DriverNotFoundException;
import com.carrental.CarRental.payloads.DriverDto;
import com.carrental.CarRental.repositories.DriverRepo;
import com.carrental.CarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DriverDto createDriver(DriverDto driverDto) {
        Driver driver=this.modelMapper.map(driverDto,Driver.class);
        String id= UUID.randomUUID().toString();
        driver.setId(id);
        Driver updateDriver=this.driverRepo.save(driver);
        DriverDto driverDto1=this.modelMapper.map(driver, DriverDto.class);
        return driverDto1;
    }

    @Override
    public List<DriverDto> getAllDrivers() {
        return driverRepo.findAll().stream().map(e-> modelMapper.map(e, DriverDto.class)).collect(Collectors.toList());
    }

    @Override
    public String deleteDriver(String id) {
        Driver driver=driverRepo.findById(id).orElseThrow(()-> new DriverNotFoundException(id));
        driverRepo.deleteById(id);
        return "driver removed";
    }
}

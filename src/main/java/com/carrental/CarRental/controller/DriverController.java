package com.carrental.CarRental.controller;

import com.carrental.CarRental.payloads.DriverDto;
import com.carrental.CarRental.service.DriverService;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/auth")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/create")
    public ResponseEntity<DriverDto> createDriver(@RequestBody DriverDto driverDto){
        DriverDto divers=this.driverService.createDriver(driverDto);
        return  new ResponseEntity<DriverDto>(divers, HttpStatus.CREATED);
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDto>> getAllDrivers(){
        List<DriverDto> driver=driverService.getAllDrivers();
        return new ResponseEntity<>(driver, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{driverId}")
    public ResponseEntity<String> deleteDriver(String id){
        String driverDto1=this.driverService.deleteDriver(id);
        return new ResponseEntity<>(driverDto1,HttpStatus.OK);
    }

}

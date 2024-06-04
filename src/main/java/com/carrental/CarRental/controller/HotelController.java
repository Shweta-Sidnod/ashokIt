package com.carrental.CarRental.controller;

import com.carrental.CarRental.payloads.DriverDto;
import com.carrental.CarRental.payloads.HotelDto;
import com.carrental.CarRental.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/driver-hotel")
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto){
        HotelDto hotels=this.hotelService.createHotel(hotelDto);
        return  new ResponseEntity<HotelDto>(hotels, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<HotelDto>> getAllHotels(){
        List<HotelDto> hotels=hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{driverId}")
    public ResponseEntity<String> deleteHotel(String id){
        String hotelDto1=this.hotelService.deleteHotel(id);
        return new ResponseEntity<>(hotelDto1,HttpStatus.OK);
    }

}

package com.carrental.CarRental.service;

import com.carrental.CarRental.payloads.DriverDto;
import com.carrental.CarRental.payloads.HotelDto;

import java.util.List;

public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto);


    List<HotelDto> getAllHotels();


    String deleteHotel(String id);
}

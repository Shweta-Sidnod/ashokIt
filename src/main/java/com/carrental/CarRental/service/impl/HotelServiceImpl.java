package com.carrental.CarRental.service.impl;

import com.carrental.CarRental.entities.Driver;
import com.carrental.CarRental.entities.Hotel;
import com.carrental.CarRental.exceptions.DriverNotFoundException;
import com.carrental.CarRental.exceptions.ResourceNotFoundException;
import com.carrental.CarRental.payloads.DriverDto;
import com.carrental.CarRental.payloads.HotelDto;
import com.carrental.CarRental.repositories.HotelRepo;
import com.carrental.CarRental.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel=this.modelMapper.map(hotelDto,Hotel.class);
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
        Hotel updatehotel=this.hotelRepo.save(hotel);
        HotelDto hotelDto1=this.modelMapper.map(hotel, HotelDto.class);
        return hotelDto1;
    }

    @Override
    public List<HotelDto> getAllHotels() {
        return hotelRepo.findAll().stream().map(e-> modelMapper.map(e, HotelDto.class)).collect(Collectors.toList());
    }

    @Override
    public String deleteHotel(String id) {
        Hotel hotel=hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        hotelRepo.deleteById(id);
        return "hotel removed";
    }
}

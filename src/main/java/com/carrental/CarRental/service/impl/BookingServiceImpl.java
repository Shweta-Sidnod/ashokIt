package com.carrental.CarRental.service.impl;

import com.carrental.CarRental.entities.Booking;
import com.carrental.CarRental.entities.Car;
import com.carrental.CarRental.exceptions.CarNotFoundException;
import com.carrental.CarRental.repositories.BookingRepo;
import com.carrental.CarRental.repositories.CarRepo;
import com.carrental.CarRental.repositories.UserRepo;
import com.carrental.CarRental.requests.BookingRequest;
import com.carrental.CarRental.response.BookingResponse;
import com.carrental.CarRental.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public BookingResponse bookCar(BookingRequest bookingRequest) {
        Car cars = this.carRepo.findById(bookingRequest.getCarId()).orElseThrow(() -> new CarNotFoundException(bookingRequest.getCarId()));
        Booking booking = modelMapper.map(bookingRequest, Booking.class);

        BookingResponse bookingResponse = new BookingResponse();

        booking.setId(UUID.randomUUID().toString());
        booking.setDays(bookingRequest.getDays());
        booking.setMembers(bookingRequest.getMembers());
        booking.setNumBags(bookingRequest.getNumBags());
        booking.setPassangerCapacity(booking.getPassangerCapacity());
        booking.setPickUpDate(bookingRequest.getPickUpDate());
        booking.setPickUpTime(bookingRequest.getPickUpTime());
        booking.setDropDate(bookingRequest.getDropDate());
        booking.setTotalPrice(cars.getCharge()*bookingRequest.getDays());
        booking.setCar(cars);
        Booking savedBooking = bookingRepo.save(booking);
        BeanUtils.copyProperties(savedBooking,bookingResponse);
        BeanUtils.copyProperties(cars,bookingResponse);



        return bookingResponse;
    }
}

package com.carrental.CarRental.service;

import com.carrental.CarRental.requests.BookingRequest;
import com.carrental.CarRental.response.BookingResponse;

public interface BookingService {
    BookingResponse bookCar(BookingRequest bookingRequest);

}
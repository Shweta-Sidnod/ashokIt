package com.carrental.CarRental.controller;

import com.carrental.CarRental.requests.BookingRequest;
import com.carrental.CarRental.response.BookingResponse;
import com.carrental.CarRental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @PostMapping("/book")
    public ResponseEntity<BookingResponse> bookCar(@RequestBody BookingRequest bookingRequest) {
        BookingResponse response = bookingService.bookCar(bookingRequest);
        return ResponseEntity.ok(response);
    }
}

package com.carrental.CarRental.controller;

import com.carrental.CarRental.entities.FinalConfirm;
import com.carrental.CarRental.requests.BookingRequest;
import com.carrental.CarRental.requests.FinalConfirmRequest;
import com.carrental.CarRental.response.BookingResponse;
import com.carrental.CarRental.response.FinalConfirmResponse;
import com.carrental.CarRental.service.AtmCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finalConfirm")
public class AtmCardController {
    @Autowired
    private AtmCardService atmCardService;


    @PostMapping("/")
    public ResponseEntity<FinalConfirmResponse> finalConfirm(@RequestBody FinalConfirmRequest finalConfirmRequest) {
        FinalConfirmResponse response = atmCardService.finalConfirm(finalConfirmRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ticketDetails/{email}")
    public ResponseEntity<List<FinalConfirm>> getTicketDetails(@PathVariable String email) {
        List<FinalConfirm> finalConform = atmCardService.getTicketDetails(email);
        return new ResponseEntity<>(finalConform, HttpStatus.FOUND);

    }
}

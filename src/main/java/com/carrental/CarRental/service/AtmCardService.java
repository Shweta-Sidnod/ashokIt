package com.carrental.CarRental.service;

import com.carrental.CarRental.entities.FinalConfirm;
import com.carrental.CarRental.requests.FinalConfirmRequest;
import com.carrental.CarRental.response.FinalConfirmResponse;

import java.util.List;

public interface AtmCardService{
    FinalConfirmResponse finalConfirm(FinalConfirmRequest finalConformRequest);

    List<FinalConfirm>getTicketDetails(String email);
}

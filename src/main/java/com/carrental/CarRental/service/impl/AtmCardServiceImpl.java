package com.carrental.CarRental.service.impl;

import com.carrental.CarRental.entities.FinalConfirm;
import com.carrental.CarRental.exceptions.ResourceNotFoundException;
import com.carrental.CarRental.repositories.BookingRepo;
import com.carrental.CarRental.repositories.FinalConfirmRepo;
import com.carrental.CarRental.requests.FinalConfirmRequest;
import com.carrental.CarRental.response.FinalConfirmResponse;
import com.carrental.CarRental.service.AtmCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AtmCardServiceImpl implements AtmCardService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private FinalConfirmRepo finalConfirmRepo;
    @Override
    public FinalConfirmResponse finalConfirm(FinalConfirmRequest finalConformRequest) {
        FinalConfirm finalConform=modelMapper.map(finalConformRequest,FinalConfirm.class);
        String id = UUID.randomUUID().toString();
        finalConform.setId(id);
        finalConform=this.finalConfirmRepo.save(finalConform);
        FinalConfirmResponse finalConformResponse=modelMapper.map(finalConform,FinalConfirmResponse.class);


        return finalConformResponse;
    }

    @Override
    public List<FinalConfirm> getTicketDetails(String email) {
        Optional<FinalConfirm> finalConform= Optional.ofNullable(finalConfirmRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("email", "email", email)));
        List<FinalConfirm> finalConforms = finalConform.stream()
                .map(finalConform1 -> modelMapper.map(finalConform1, FinalConfirm.class))
                .collect(Collectors.toList());
        return finalConforms;

    }
}

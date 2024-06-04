package com.carrental.CarRental.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class CarDto {
    private String id;
    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carImg;
    private String car360;
    private String carOwner;
    private String numPlate;
    private LocalDate regDate;
    private String insurance;
    private LocalDate insuranceValidity;
    private Integer passangerCapacity;
    private String fuelType;
    private String feature;
    private Long totalRunning;
    private Long charge;
}

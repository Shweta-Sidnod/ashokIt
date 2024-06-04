package com.carrental.CarRental.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DriverDto {
    private String id;
    private  String driverImg;
    private String driverName;
    private String drivingExperiance;
    private  Long driverMobNo;
    private String availability;
    private String food;
    private String smoke;
    private String drink;
    private Integer charges;
}

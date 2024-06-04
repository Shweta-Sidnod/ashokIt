package com.carrental.CarRental.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Entity
public class Driver {

    @Id
    @Column(name = "driverId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String driverImg;
    private String driverName;
    private String drivingExperiance;
    private Long driverMobNo;
    private String availability;
    private String food;
    private String smoke;
    private String drink;
    private Integer charges;

   private List<Booking> booking;
}

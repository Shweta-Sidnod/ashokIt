package com.carrental.CarRental.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@Entity
public class Car {

    @Id
    @Column(name = "carId")
    @GeneratedValue(strategy = GenerationType.UUID)
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
          private Double charge;


      @OneToMany(mappedBy = "car")
      private List<Booking> booking;

}

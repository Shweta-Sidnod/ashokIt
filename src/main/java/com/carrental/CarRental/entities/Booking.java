package com.carrental.CarRental.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Data
@Getter
@Setter
public class Booking {
    @Id
    private String id;
    private String pickUpLocation;
    private String dropLocation;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate dropDate;
    private Integer passangerCapacity;
    private String members;
    private Integer days;
    private String numBags;
    private Double totalPrice;



    @JdbcTypeCode(SqlTypes.JSON)
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId")
    private Car car;


}


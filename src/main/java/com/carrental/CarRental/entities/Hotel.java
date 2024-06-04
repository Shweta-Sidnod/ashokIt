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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String hotel;
    private String room;
    private Integer stay;
    private String manageParking;
    private Double finalCost;



}

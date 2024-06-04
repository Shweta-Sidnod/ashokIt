package com.carrental.CarRental.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
public class AtmCard {
    @Id
    @Column(name = "atmId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private  String cardHolderName;
    private long cardNo;
    private Date expDate;
    @Transient
    private int cvv;



}

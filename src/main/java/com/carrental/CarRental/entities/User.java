package com.carrental.CarRental.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fname;
    private String lname;
    private String password;
    private String email;
    private Date dob;


}

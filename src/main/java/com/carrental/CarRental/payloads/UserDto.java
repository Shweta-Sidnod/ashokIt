package com.carrental.CarRental.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class UserDto {
    private String id;
    private String fname;
    private String lname;
    private String password;
    private String email;
    //private long mobileNumber;
    private Date dob;
}

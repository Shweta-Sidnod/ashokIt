package com.carrental.CarRental.service;

import com.carrental.CarRental.entities.User;
import com.carrental.CarRental.payloads.UserDto;

public interface UserService {
    UserDto registerUser(UserDto userDto);

    String editUser(UserDto userDto, String id);

    String deleteUser(String id);

    User login(String email, String password);
}

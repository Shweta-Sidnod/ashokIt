package com.carrental.CarRental.service.impl;


import com.carrental.CarRental.entities.User;
import com.carrental.CarRental.exceptions.UserNotFoundException;
import com.carrental.CarRental.payloads.UserDto;
import com.carrental.CarRental.repositories.UserRepo;
import com.carrental.CarRental.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto registerUser(UserDto userDto) {
        if(userRepo.findByEmail(userDto.getEmail()).isPresent()){
            throw new RuntimeException("email is already present");
        }

        User user=modelMapper.map(userDto,User.class);
        String id= UUID.randomUUID().toString();
        user.setId(id);
        user.setFname(userDto.getFname());
        user.setLname(userDto.getLname());
        user.setEmail(userDto.getEmail());
      //  user.setMobileNumber(userDto.getMobileNumber());
        user.setDob(userDto.getDob());
        user.setPassword(userDto.getPassword());
        User updatedUser= this.userRepo.save(user);
        UserDto userDto1=modelMapper.map(updatedUser,UserDto.class);



        return userDto1;
    }

    @Override
    public String editUser(UserDto userDto, String id) {
        User user=userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
        user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        if(userRepo.save(user)!=null) return "Changes saved successfully";
        return "User not updated, please try again";
    }

    @Override
    public String deleteUser(String id) {
        User user=userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
        userRepo.delete(user);
        return "User deleted successfully";
    }

    public User login(String email, String password) {
        return userRepo.findByEmailAndPassword(email,password);
    }
}

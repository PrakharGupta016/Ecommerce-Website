package com.project.supermarketapp.services;

import com.project.supermarketapp.entities.User;
import com.project.supermarketapp.exceptions.ResourceNotFoundException;
import com.project.supermarketapp.payloads.UserDto;
import com.project.supermarketapp.respository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);


        return this.userToDto(savedUser);
    }
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","User ID",userId));

        user.setFirst_name(userDto.getFirst_name());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLast_name(userDto.getLast_name());
        User updatedUser = this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }
    public UserDto getUser(Integer userId) {
        // TODO Auto-generated method stub
        User user  = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","User ID",userId));

        return this.userToDto(user);
    }
    public List<UserDto> getAllUsers() {
        List<User> users= this.userRepo.findAll();
        List<UserDto>userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }
    public void deleteUser(Integer userId) {
        // TODO Auto-generated method stub
        User user  = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","User ID",userId));
        this.userRepo.delete(user);
        return;

    }
    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);


        return user;

    }
    private UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user,UserDto.class);

        return userDto;

    }


}


package com.project.supermarketapp.controllers;

import com.project.supermarketapp.payloads.ApiResponse;
import com.project.supermarketapp.payloads.UserDto;
import com.project.supermarketapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto){
        UserDto createdUserDto =this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);


    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto,@PathVariable Integer userId){
        UserDto updatedUser  = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successful",true),HttpStatus.OK);


    }
    //GET-user get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());

    }
    //GET-single user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUser(userId));

    }
}


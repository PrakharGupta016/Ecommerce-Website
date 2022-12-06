package com.project.supermarketapp.controllers;

import com.project.supermarketapp.payloads.ApiResponse;
import com.project.supermarketapp.payloads.UserDto;
import com.project.supermarketapp.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.razorpay.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> signUpUser( @RequestBody UserDto userDto){
        UserDto createdUserDto =this.userService.signUpUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);


    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto,@PathVariable Integer userId){
        UserDto updatedUser  = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUser(userId));

    }

    //Creating order for payment
    //Response Body
    @PostMapping("/create_order")
    public String createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {
        int amount=Integer.parseInt(data.get("amount").toString());
        RazorpayClient razorpayClient= new RazorpayClient("rzp_test_EKtW453UQaizbN","5HY2GCYMhBn8H837uDhq9Jcu");

        JSONObject options = new JSONObject();
        options.put("amount", amount*100);
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        Order order = razorpayClient.Orders.create(options);
        return order.toString();
    }
}


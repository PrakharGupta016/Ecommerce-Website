package com.project.supermarketapp.controllers;

import com.project.supermarketapp.entities.User;
import com.project.supermarketapp.payloads.ApiResponse;
import com.project.supermarketapp.payloads.UserDto;
import com.project.supermarketapp.payloads.dto_cart.AddToCartDto;
import com.project.supermarketapp.payloads.dto_cart.CartDto;
import com.project.supermarketapp.security.CustomUserDetailService;
import com.project.supermarketapp.security.JwtTokenHelper;
import com.project.supermarketapp.services.AuthenticationService;
import com.project.supermarketapp.services.CartService;
import com.project.supermarketapp.services.UserService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("api/cart/")
@CrossOrigin

public class CartController  {

    @Autowired
    private CartService cartService;

//    @Autowired
//    private AuthenticationService authenticationService;
//    @Autowired
//    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;


    // post cart api
    @PostMapping("/add/{userId}")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,@PathVariable Integer userId){
        // authenticate the token
//        String username = this.jwtTokenHelper.getUsernameFromToken(token);
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        User user = userService.dtoToUser(userService.getUser(userId));

        // find the user



        cartService.addToCart(addToCartDto, user );

        return new ResponseEntity<>(new ApiResponse("Added to cart", true), HttpStatus.CREATED);
    }


    // get all cart items for a user
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestBody Integer userId) {
        // authenticate the token
//        String username = this.jwtTokenHelper.getUsernameFromToken(token);
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        // get cart items
        User user = userService.dtoToUser(userService.getUser(userId));
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    // delete a cart item for a user

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
                                                      @RequestBody Integer userId) {
        User user = userService.dtoToUser(userService.getUser(userId));
        CartDto cartDto = cartService.listCartItems(user);

        cartService.deleteCartItem(itemId, (User) user);

        return new ResponseEntity<>(new ApiResponse("Item has been removed", true), HttpStatus.OK);

    }

}

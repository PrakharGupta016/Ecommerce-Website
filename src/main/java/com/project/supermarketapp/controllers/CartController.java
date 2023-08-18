package com.project.supermarketapp.controllers;

import com.project.supermarketapp.entities.User;
import com.project.supermarketapp.payloads.ApiResponse;
import com.project.supermarketapp.payloads.dto_cart.AddToCartDto;
import com.project.supermarketapp.payloads.dto_cart.CartDto;
import com.project.supermarketapp.security.CustomUserDetailService;
import com.project.supermarketapp.security.JwtTokenHelper;
import com.project.supermarketapp.services.AuthenticationService;
import com.project.supermarketapp.services.CartService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/cart/")
@CrossOrigin

public class CartController  {

    @Autowired
    private CartService cartService;

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;



    // post cart api
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                 @RequestParam("token") String token) {
        // authenticate the token
        String username = this.jwtTokenHelper.getUsernameFromToken(token);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);


        // find the user



        cartService.addToCart(addToCartDto, (User)userDetails );

        return new ResponseEntity<>(new ApiResponse("Added to cart", true), HttpStatus.CREATED);
    }


    // get all cart items for a user
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
        // authenticate the token
        String username = this.jwtTokenHelper.getUsernameFromToken(token);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        // get cart items

        CartDto cartDto = cartService.listCartItems((User) userDetails);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    // delete a cart item for a user

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
                                                      @RequestParam("token") String token) {

        // authenticate the token
        String username = this.jwtTokenHelper.getUsernameFromToken(token);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        cartService.deleteCartItem(itemId, (User) userDetails);

        return new ResponseEntity<>(new ApiResponse("Item has been removed", true), HttpStatus.OK);

    }

}

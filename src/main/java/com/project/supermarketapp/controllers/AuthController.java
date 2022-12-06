package com.project.supermarketapp.controllers;


import com.project.supermarketapp.payloads.JwtAuthRequest;
import com.project.supermarketapp.payloads.JwtAuthResponse;
import com.project.supermarketapp.security.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth/")
public class AuthController {

  @Autowired
private JwtTokenHelper jwtTokenHelper;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private AuthenticationManager authenticationManager;


  @PostMapping("/login")
  public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
      this.authenticate(request.getUsername(),request.getPassword());
    UserDetails userDetails =this.userDetailsService.loadUserByUsername(request.getUsername());
      String token=this.jwtTokenHelper.generateToken(userDetails);
    JwtAuthResponse response =new JwtAuthResponse();
    response.setToken(token);
    return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
  }

  private void authenticate(String username, String password) throws Exception {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
            password);


    try {

      this.authenticationManager.authenticate(authenticationToken);

    } catch (BadCredentialsException e) {
      System.out.println("Invalid Detials !!");
      throw new Exception("Invalid username or password !!");
    }
  }

}

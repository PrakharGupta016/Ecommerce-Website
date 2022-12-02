package com.project.supermarketapp.security;

import com.project.supermarketapp.controllers.entities.User;
import com.project.supermarketapp.exceptions.ResourceNotFoundException;
import com.project.supermarketapp.respository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","email"+username,0));
        return user;

    }
}

package com.project.supermarketapp.services;

import com.project.supermarketapp.config.AppConstants;
import com.project.supermarketapp.entities.Role;
import com.project.supermarketapp.entities.User;
import com.project.supermarketapp.exceptions.ResourceNotFoundException;
import com.project.supermarketapp.payloads.UserDto;
import com.project.supermarketapp.respository.ProductRepository;
import com.project.supermarketapp.respository.RoleRepo;
import com.project.supermarketapp.respository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;



    public UserDto signUpUser(UserDto userDto) {
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
    public UserDto getUserByUsername(String email) {
        // TODO Auto-generated method stub
        User user  = this.userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User with email does not exist"));

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
    public void deleteUserByUsername(String email) {
        // TODO Auto-generated method stub
        User user  = this.userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User with email does not exist"));
        this.userRepo.delete(user);
        return;

    }



    public User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);


        return user;

    }
    public UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user,UserDto.class);

        return userDto;

    }
//    User save (UserDto registrationDto){}

public UserDto registerNewUser(UserDto userDto) {

    User user = this.modelMapper.map(userDto, User.class);

    // encoded the password
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));

    // roles
    Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();

    user.getRoles().add(role);

    User newUser = this.userRepo.save(user);

    return this.modelMapper.map(newUser, UserDto.class);
}
    public UserDto registerNewAdmin(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);

        // encoded the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        // roles
        Role role = this.roleRepo.findById(AppConstants.ADMIN_USER).get();

        user.getRoles().add(role);

        User newUser = this.userRepo.save(user);

        return this.modelMapper.map(newUser, UserDto.class);
    }

}


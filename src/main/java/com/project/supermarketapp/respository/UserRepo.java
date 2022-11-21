package com.project.supermarketapp.respository;

import com.project.supermarketapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Integer> {

}

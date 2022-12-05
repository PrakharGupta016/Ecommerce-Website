package com.project.supermarketapp.respository;

import com.project.supermarketapp.entities.Cart;
import com.project.supermarketapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}

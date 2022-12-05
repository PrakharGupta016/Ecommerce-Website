package com.project.supermarketapp.respository;

import com.project.supermarketapp.entities.Product;
import com.project.supermarketapp.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
     public  Product findByname(String name);



}
package com.project.supermarketapp.respository;

import com.project.supermarketapp.entities.Category;

import com.project.supermarketapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Integer>
{

}

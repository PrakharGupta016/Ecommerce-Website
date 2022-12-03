package com.project.supermarketapp.respository;

import com.project.supermarketapp.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}

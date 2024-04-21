package com.project.supermarketapp.respository;

import com.project.supermarketapp.entities.Category;
import com.project.supermarketapp.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
     public  Product findByName(String name);
     List<Product> findAll();
//     List<Product> findAll(Pageable pageable);

//     List<Product>findByNameContainingIgnoreCase(Pageable pageable);
     List<Product> findByCategory(Category category);


}
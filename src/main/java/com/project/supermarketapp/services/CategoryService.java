package com.project.supermarketapp.services;

import com.project.supermarketapp.payloads.CategoryDto;

import java.util.List;


public interface CategoryService {

    //create
       CategoryDto createCategory(CategoryDto categoryDto);

    //update
       CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId); //id of old category

    //delete
      void deleteCategory(Integer categoryId);

    //get
    CategoryDto getCategory(Integer categoryId);

    //get all
    List<CategoryDto> getCategories();

}

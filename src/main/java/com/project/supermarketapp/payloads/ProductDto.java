package com.project.supermarketapp.payloads;

import com.sun.istack.NotNull;

//import javax.validation.constraints.NotNull;

public class ProductDto {
    // for create it can be optional
    // for update we need the id
    private Integer id;
    private @NotNull String name;
    private @NotNull String imageURL;

    private @NotNull double costPrice;

    private @NotNull double salePrice;
    private @NotNull String description;
    private @NotNull Integer categoryId;


    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costprice) {
        this.costPrice = costprice;
    }

    public double getSalePrice(){
        return salePrice;
    }

    public void setSalePrice(double salePrice){
        this.salePrice= salePrice;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
package com.project.supermarketapp.payloads;

import com.project.supermarketapp.entities.Image;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

//import javax.validation.constraints.NotNull;

@Getter
@Setter
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
//    private Set<Image> images;

    public ProductDto() {
    }

}
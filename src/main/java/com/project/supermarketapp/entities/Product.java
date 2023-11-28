package com.project.supermarketapp.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @NotNull Integer id;

    private @NotNull String name;
    private @NotNull String imageURL;

    private @NotNull double costPrice;

    private @NotNull double salePrice;
    private @NotNull String description;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name ="product_images",
            joinColumns = {
                    @JoinColumn(name ="product_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name ="image_id")
            }
    )
    private Set<Image> images;



    // idMany-to-one relationship
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Cart> cart;



}
package com.project.supermarketapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String customerName;

    private String address;

    private String contactNumber;
    private String status;
    private Double amount;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;

}

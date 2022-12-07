package com.project.supermarketapp.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class Role {

    @Id
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
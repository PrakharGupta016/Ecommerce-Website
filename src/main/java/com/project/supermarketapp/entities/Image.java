package com.project.supermarketapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String imageName;
    private String type;
    @Column(length = 90000000) // bytes size
    private byte[] bytes;

}

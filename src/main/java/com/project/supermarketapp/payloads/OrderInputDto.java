package com.project.supermarketapp.payloads;

import lombok.Data;
import org.springframework.boot.SpringApplication;

import java.util.List;

@Data
public class OrderInputDto {

    private String customerName;

    private String address;

    private String contactNumber;

    private List<ProductCheckoutDetailsDto> checkoutDetials;
}

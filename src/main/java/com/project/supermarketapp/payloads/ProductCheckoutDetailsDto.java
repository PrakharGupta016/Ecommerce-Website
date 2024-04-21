package com.project.supermarketapp.payloads;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class ProductCheckoutDetailsDto {
    private Integer productId;
    private Integer quantity;
}

package com.project.supermarketapp.controllers;

import com.project.supermarketapp.payloads.OrderInputDto;
import com.project.supermarketapp.payloads.ProductCheckoutDetailsDto;
import com.project.supermarketapp.services.OrderDetailService;
import com.project.supermarketapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderDetailController   {
    @Autowired
    private OrderDetailService orderDetailService;
    @PostMapping("/")
    public void placeOrder(@RequestBody OrderInputDto orderInputDto)
    {
        orderDetailService.placeOrder(orderInputDto);
    }
}

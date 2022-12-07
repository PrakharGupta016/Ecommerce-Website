package com.project.supermarketapp.services;

import com.project.supermarketapp.entities.Order;
import com.project.supermarketapp.entities.User;
import com.project.supermarketapp.exceptions.OrderException;
import com.project.supermarketapp.payloads.OrderDto;
import java.time.LocalDate;
import java.util.List;
import javax.security.auth.login.LoginException;

public interface OrderService {
  public Order saveOrder(OrderDto orderDto,String token) throws LoginException, OrderException;

  public Order getOrderByOrderId(Integer OrderId) throws OrderException;

  public List<Order> getAllOrders() throws OrderException;

  public Order cancelOrderByOrderId(Integer OrderId,String token) throws OrderException;

  public Order updateOrderByOrder(OrderDto order,Integer OrderId,String token) throws OrderException,LoginException;

  public List<Order> getAllOrdersByDate(LocalDate date) throws OrderException;

  public User getUserByOrderId(Integer orderId) throws OrderException;

  //public Customer getCustomerIdByToken(String token) throws CustomerNotFoundException;



}
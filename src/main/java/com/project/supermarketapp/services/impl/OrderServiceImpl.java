package com.project.supermarketapp.services.impl;

import com.project.supermarketapp.entities.Order;
import com.project.supermarketapp.entities.User;
import com.project.supermarketapp.exceptions.OrderException;
import com.project.supermarketapp.payloads.OrderDto;
import com.project.supermarketapp.respository.OrderRepo;
import com.project.supermarketapp.services.CartService;
import com.project.supermarketapp.services.OrderService;
import com.project.supermarketapp.services.UserService;
import com.razorpay.Customer;
import java.time.LocalDate;
import java.util.List;
import javax.security.auth.login.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Override
  public Order saveOrder(OrderDto orderDto, String token) throws LoginException, OrderException {
    return null;
  }

  @Override
  public Order getOrderByOrderId(Integer OrderId) throws OrderException {
    return null;
  }

  @Override
  public List<Order> getAllOrders() throws OrderException {
    return null;
  }

  @Override
  public Order cancelOrderByOrderId(Integer OrderId, String token) throws OrderException {
    return null;
  }

  @Override
  public Order updateOrderByOrder(OrderDto order, Integer OrderId, String token)
      throws OrderException, LoginException {
    return null;
  }

  @Override
  public List<Order> getAllOrdersByDate(LocalDate date) throws OrderException {
    return null;
  }

  @Override
  public User getUserByOrderId(Integer orderId) throws OrderException {
    return null;
  }
}
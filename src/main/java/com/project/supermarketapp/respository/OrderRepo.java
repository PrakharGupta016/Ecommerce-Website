package com.project.supermarketapp.respository;

import com.project.supermarketapp.entities.Order;
import com.project.supermarketapp.entities.User;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
  public List<Order> findByDate(LocalDate date);

//	@Query("select c.orders from Customer c where c.customerId = customerId")
//	public List<Order> getListOfOrdersByUserid(@Param("customerId") Integer customerId);

//  @Query("select c from Customer c where c.customerId = customerId")
  public User getUserByOrderId(@Param("userId") Integer userId);}
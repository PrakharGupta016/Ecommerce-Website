package com.project.supermarketapp.respository;


import com.project.supermarketapp.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

}

package com.project.supermarketapp.services;

import com.project.supermarketapp.entities.OrderDetail;
import com.project.supermarketapp.entities.Product;
import com.project.supermarketapp.entities.User;
import com.project.supermarketapp.payloads.OrderInputDto;
import com.project.supermarketapp.payloads.ProductCheckoutDetailsDto;
import com.project.supermarketapp.respository.OrderDetailRepository;
import com.project.supermarketapp.respository.ProductRepository;
import com.project.supermarketapp.respository.UserRepo;
import com.project.supermarketapp.security.JwtAuthenticationFilter;
import org.hibernate.internal.util.type.PrimitiveWrapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;

    private final String ORDER_PLACED = "PLACED";

    @Autowired
    private UserDetailsService userDetailsService;
    public void placeOrder(OrderInputDto orderInputDto)
    {
        List<ProductCheckoutDetailsDto> checkoutDetails = orderInputDto.getCheckoutDetials();

        for(ProductCheckoutDetailsDto details: checkoutDetails)
        {
            Product prod = productRepository.findById(details.getProductId()).get();
            Double price  = prod.getSalePrice();
            User  userDetails = (User) userDetailsService.loadUserByUsername(JwtAuthenticationFilter.CURRENT_USER);
            OrderDetail orderDetail = new OrderDetail( );
            orderDetail.setCustomerName(orderInputDto.getCustomerName());
            orderDetail.setContactNumber(orderInputDto.getContactNumber());
            orderDetail.setAddress(orderInputDto.getAddress());
            orderDetail.setAmount((double) (details.getQuantity()*price));
            orderDetail.setStatus(ORDER_PLACED);
            orderDetail.setProduct(prod);
            orderDetail.setUser(userDetails);
            orderDetailRepository.save(orderDetail);


        }

    }

}

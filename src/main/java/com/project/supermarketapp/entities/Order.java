package com.project.supermarketapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer orderId;
  @PastOrPresent
  private LocalDate date;
  @NotNull
  @Enumerated(EnumType.STRING)
  private OrderStatusValues orderStatus;

  private Double total;

  private String cardNumber;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "userId")
  private User user;

  @OneToMany
  private List<Cart> cartList = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "address_id", referencedColumnName = "addressId")
  private Address address;
}
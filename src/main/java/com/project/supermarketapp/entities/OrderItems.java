//package com.project.supermarketapp.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.domain.Page;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Entity
//public class OrderItems {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Integer cartItemId;
//
//
//  @OneToOne
//  @JsonIgnoreProperties(value={
//      "productId",
//      "seller",
//      "quantity"
//
//  })
//  private Product cartProduct;
//
//  private Integer cartItemQuantity;
//
//}
package com.project.supermarketapp.payloads;

import com.project.supermarketapp.entities.CreditCard;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDto {

  @NotNull
  @Embedded
  private CreditCard cardNumber;
  @NotNull
  private String addressType;
}

package com.project.supermarketapp.payloads;

public class WalletDto {

  private Integer id;

  //  @NotBlank(message = "Name can't be blank")
//  @Size(min = 2,max = 30)
  private String name;
  //  @Size(min = 2,max = 30)
  private String accountNumber;
  //  @Size(max = 100)
  private String description;

  private Double currentBalance;
}

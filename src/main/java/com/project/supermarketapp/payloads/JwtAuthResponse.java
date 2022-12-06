package com.project.supermarketapp.payloads;

import lombok.Data;

@Data
public class JwtAuthResponse {
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}

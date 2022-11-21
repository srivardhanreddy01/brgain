package com.example.brgain.model.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
  private boolean success = true;
  private Integer code;
  private Integer errorCode;
  private String errorMessage;
  private T data;

  public ApiResponse(T data) {
    this.data = data;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public String toString() {
    return new com.google.gson.Gson().toJson(this);
  }
}

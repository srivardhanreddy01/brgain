package com.example.brgain.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Item {
  Integer itemId;
  String itemName;
  Integer categoryId;
  String itemImage;
}

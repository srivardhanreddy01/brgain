package com.example.brgain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ItemEntry {
  Integer itemEntryId;
  String itemEntryName;
  String imageUrl;
  String productUrl;
  Integer storeId;
  Double price;
}

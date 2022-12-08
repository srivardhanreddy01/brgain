package com.example.brgain.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class ItemEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer itemEntryId;
  String itemEntryName;
  String imageUrl;
  String productUrl;
  Integer storeId;
  Double price;
}

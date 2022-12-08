package com.example.brgain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@IdClass(ShoppingListItem.class)
public class ShoppingListItem implements Serializable {


  @Id
  private Integer shoppingListId;

  @Id
  private Integer itemEntryId;
}

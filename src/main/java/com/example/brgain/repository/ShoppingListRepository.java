package com.example.brgain.repository;

import com.example.brgain.model.ItemEntry;
import com.example.brgain.model.ShoppingList;
import com.example.brgain.model.ShoppingListItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {

  @Query("select ie from ShoppingList sl join ShoppingListItem sli on sl.shoppingListId = sli" +
          ".shoppingListId  join ItemEntry ie on sli.itemEntryId = ie.itemEntryId  where sl" +
          ".userId = :userId")
  List<ItemEntry> findItemEntriesByUserId(Integer userId);

  ShoppingList findByUserId(Integer userId);
}

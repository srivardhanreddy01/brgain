package com.example.brgain.repository;

import com.example.brgain.model.ShoppingListItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ShoppingListItemRepository  extends JpaRepository<ShoppingListItem, ShoppingListItem> {
}

package com.example.brgain.repository;

import com.example.brgain.model.Category;
import com.example.brgain.model.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryRepository  extends JpaRepository<Store, Integer> {
  @Query("select c from Category  c")
  List<Category> findAllCategories();

//  @Query("select I.itemId, I.categoryId, I.itemName, min(IE.imageUrl)  from Item I " +
//          "join ItemEntry IE on I.itemId = IE.itemId " +
//          "where I.categoryId = ?1 " +
//          "group by I.itemId, I.categoryId, I.itemName ")
//  List findItemsByCategory();


}

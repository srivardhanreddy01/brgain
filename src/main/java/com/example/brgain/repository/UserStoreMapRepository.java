package com.example.brgain.repository;

import com.example.brgain.model.Store;
import com.example.brgain.model.UserStoreMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.*;
import java.util.List;

public interface UserStoreMapRepository  extends JpaRepository<UserStoreMap, UserStoreMap> {

  @Query("select s from UserStoreMap  usm join Store  s on usm.storeId = s.storeId " +
          "where usm.userId = ?1 ")
  public List<Store> findAllStoresForUser(Integer userId);
}

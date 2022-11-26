package com.example.brgain.repository;

import com.example.brgain.model.Store;
import com.example.brgain.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StoreRepository  extends JpaRepository<Store, Integer> {

  @Query("select s from Store s " )
  List<Store> findAllStores();



}

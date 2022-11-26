package com.example.brgain.service;

import com.example.brgain.model.Store;
import com.example.brgain.repository.StoreRepository;
import com.example.brgain.repository.UserStoreMapRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StoreService {

  @Autowired
  private StoreRepository storeRepository;

  @Autowired
  private UserStoreMapRepository userStoreMapRepository;



  public List<Store> findAllStores(){
    return storeRepository.findAllStores();
  }


  public List<Store> findAllStoresByUserId(Integer userId){
    if(Objects.isNull(userId) || userId <= 0 ){
      throw new IllegalArgumentException("Input UserID is null");
    }
    return userStoreMapRepository.findAllStoresForUser(userId);
  }
}

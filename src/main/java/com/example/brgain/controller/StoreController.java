package com.example.brgain.controller;

import com.example.brgain.model.Store;
import com.example.brgain.model.User;
import com.example.brgain.model.core.ApiResponse;
import com.example.brgain.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "store")
public class StoreController {

  @Autowired
  private StoreService storeService;


  @RequestMapping(path="/all" , method = RequestMethod.GET)
  public ApiResponse<?> getAllStores() {
    List<Store> allStores = storeService.findAllStores();
    return new ApiResponse<>(allStores);
  }


  @RequestMapping(path="/user" , method = RequestMethod.GET)
  public ApiResponse<?> getAllStoresForUser(@RequestParam("userId") Integer userId) {
    List<Store> allStores = storeService.findAllStoresByUserId(userId);
    return new ApiResponse<>(allStores);
  }





}

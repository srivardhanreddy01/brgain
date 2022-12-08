package com.example.brgain.service;

import com.example.brgain.model.Category;
import com.example.brgain.model.Item;
import com.example.brgain.model.ItemEntry;
import com.example.brgain.model.Store;
import com.example.brgain.repository.CategoryRepository;
import com.example.brgain.repository.CustomRepository;
import com.example.brgain.repository.StoreRepository;
import com.example.brgain.repository.UserStoreMapRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StoreService {

  @Autowired
  private StoreRepository storeRepository;

  @Autowired
  private UserStoreMapRepository userStoreMapRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private CustomRepository customRepository;



  public List<Store> findAllStores(){
    return storeRepository.findAllStores();
  }


  public List<Store> findAllStoresByUserId(Integer userId){
    if(Objects.isNull(userId) || userId <= 0 ){
      throw new IllegalArgumentException("Input UserID is null");
    }
    return userStoreMapRepository.findAllStoresForUser(userId.toString());
  }

  public List<Category> findAllCategories(){
    return categoryRepository.findAllCategories();
  }

  public  List<Item> findItemsByCategory(Integer categoryId){
    List itemsByCategory = customRepository.getItemsByCategory(categoryId);
    List<Item> responseList  = new ArrayList<>();
    for (Object each : itemsByCategory) {
      Object[] eachList = (Object[]) each;
      Item build = Item.builder().itemImage(eachList[3].toString())
              .itemId(Integer.valueOf(eachList[0].toString()))
              .categoryId((int) eachList[1])
              .itemName((String) eachList[2])
              .build();
      responseList.add(build);
    }
    return responseList;
  }


  public  List<ItemEntry> findItemEntriesByItemId(Integer itemId){
    List itemEntries = customRepository.getItemEntriesByItemId(itemId);
    List<ItemEntry> responseList  = new ArrayList<>();
    for (Object each : itemEntries) {
      Object[] eachList = (Object[]) each;
      ItemEntry itemEntry = ItemEntry.builder()
              .itemEntryId((int)eachList[0])
              .itemEntryName(eachList[1].toString())
              .storeId((int) eachList[4])
              .imageUrl(eachList[2].toString())
              .price(Double.parseDouble(eachList[5].toString()))
              .productUrl(eachList[3].toString())
              .build();

      responseList.add(itemEntry);
    }
    return responseList;
  }





}

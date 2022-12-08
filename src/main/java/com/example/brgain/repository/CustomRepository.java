package com.example.brgain.repository;

import com.example.brgain.model.Item;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CustomRepository {

  @PersistenceContext
  private EntityManager em;


  public List getItemsByCategory(Integer category){
    Query nativeQuery = em.createNativeQuery("select I.itemId as itemId, I.categoryId as " +
            "categoryId, I.itemName as itemName, min(IE" +
            ".imageUrl)  as itemImage from Item I " +
            "join ItemEntry IE on I.itemId = IE.itemId " +
            "where I.categoryId = :param " +
            "group by I.itemId, I.categoryId, I.itemName ");
    nativeQuery.setParameter("param", category);


    List resultList =  nativeQuery.getResultList();

    return resultList;

  }

  public List getItemEntriesByItemId(Integer itemId){
    Query nativeQuery = em.createNativeQuery("select\n" +
            "    itemEntryId,\n" +
            "    itemEntryName,\n" +
            "    imageUrl,\n" +
            "    productUrl,\n" +
            "    storeId,\n" +
            "    price\n" +
            "    from ItemEntry  where itemId = :itemId");
    nativeQuery.setParameter("itemId", itemId);

    List resultList =  nativeQuery.getResultList();

    return resultList;

  }



}

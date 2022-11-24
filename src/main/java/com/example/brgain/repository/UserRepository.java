package com.example.brgain.repository;
import  com.example.brgain.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{

//class UserRepository extends AbstractRepository
//        public List<User> getUsers(){
//
//    String sqlQuery = " select * from user ;";
//    Query query = getSession().createSQLQuery(sqlQuery);
////    query.setParameter("facilityId", facilityId);
////    query.setParameter("costCenter", costCenter);
//    query.setResultTransformer(Transformers.aliasToBean(User.class));
//    return query.list();
//  }

//  @Query("SELECT t FROM Tutorial t WHERE t.published=true")
//  List<Tutorial> findByPublished();

  @Query("select u from User u where u.email = ?1 and u.password = ?2 " )
  List<User> findByEmailAndPassword(String email, String password);

  @Query("select u from User u where u.email = ?1 " )
  List<User> findByEmail(String email);




}

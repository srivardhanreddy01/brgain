package com.example.brgain.repository;
import  com.example.brgain.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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


}

package com.example.brgain.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional(transactionManager = "coreTransactionManager")
public abstract class AbstractRepository {
  @PersistenceContext(name = "coreTransactionManager", unitName = "coreEntityManager")
  @Qualifier("coreEntityManager")
  protected EntityManager entityManager;

  protected Session getSession() {
    return entityManager.unwrap(Session.class);
  }

}

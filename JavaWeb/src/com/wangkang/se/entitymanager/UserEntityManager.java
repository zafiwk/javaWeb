package com.wangkang.se.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wangkang.se.domain.User;

public class UserEntityManager
{
    public  void savaUser(User  user)
    {
    	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("mysql");
    	EntityManager  entityManager=entityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
    	entityManager.persist(user);
    	entityManager.getTransaction().commit();
    	entityManager.clear();
    	entityManager.close();
    }
}

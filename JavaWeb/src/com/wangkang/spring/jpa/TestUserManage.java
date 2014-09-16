package com.wangkang.spring.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class TestUserManage
{

	@Test
	public void test1()
	{
		// 没有使用Spring
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		User user = new User();
		user.setUsername("000000");
		user.setPassword("000000");
		user.setSex("000000");
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		System.out.println(user.getId());
		entityManager.close();

	}

	
}

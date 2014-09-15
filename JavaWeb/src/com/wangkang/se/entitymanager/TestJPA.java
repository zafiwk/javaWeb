package com.wangkang.se.entitymanager;

import org.junit.Test;

import com.wangkang.se.domain.User;

public class TestJPA
{
	@Test
	public void test()
	{
		User u=new User();
		u.setUsername("111111");
		u.setPassword("111111");
		u.setSex("11111");
		UserEntityManager uem=new UserEntityManager();
		uem.savaUser(u);
	}
}

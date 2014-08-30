package com.wangkang.se.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.junit.Test;

public class TestPersonDao
{
	@Test
	public void testQueryList()
	{
		List<Person>   list=new ArrayList<>();
		PersonXMLDao dao=new PersonXMLDao();
		try
		{
			list=dao.queryList(list);
			for(Person person :list)
			{
				System.out.println(person.getId());
				System.out.println(person.getUsernmae());
				System.out.println(person.getPassword());
				System.out.println(person.getSex());
			}
		} catch (DocumentException e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public  void testAddPerson()
	{
		Person person=new Person();
		person.setPassword("aaaaaaaaaa");
		person.setSex("女");
		person.setUsernmae("bbbbbbbbb");
		PersonXMLDao dao=new PersonXMLDao();
		try
		{
			dao.addPerson(person);
		} catch (DocumentException | IOException e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public   void testDeleteElementById()
	{
		PersonXMLDao dao=new PersonXMLDao();
		try
		{
			dao.deletePersonById(5);
		} catch (DocumentException | IOException e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public  void  testPerson()
	{
		Person person=new Person();
		System.out.println(person.getId());
	}
	@Test
	public  void testupdateOrAddPerson() throws DocumentException, IOException
	{
		PersonXMLDao dao=new PersonXMLDao();
		Person person=new Person();
		person.setPassword("ccccc");
		person.setSex("nan");
		person.setUsernmae("ccc");
		int  id=dao.addPerson(person);
		person.setId(id);
		person.setUsernmae("mmmm");
		dao.updateOrAddPerson(person);
	}
}

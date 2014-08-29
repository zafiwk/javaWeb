package com.wangkang.se.json;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestJson
{
	
	//public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray 
	//public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject    
	//public static final  T parseObject(String text, Class clazz); // 把JSON文本parse为JavaBean 
	//public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray 
	//public static final  List parseArray(String text, Class clazz); //把JSON文本parse成JavaBean集合 
	//public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本 
	//public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本 
	//public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
	@Test
	public void test1()
	{
		//将一个对象转换成json
		Person  person=new Person();
		person.setId(10);
		person.setPassword("xxxxxxx");
		person.setUsernmae("yyyyyyy");
		person.setSex("nan");
		String str=JSON.toJSONString(person);
		System.out.println(str);
	}
	
	@Test
	public  void  test2()
	{
		//将一个json转换成对象
		String str="{'id':10,'password':'xxxxxxx','sex':'nan','usernmae':'yyyyyyy'}";
		Person person=(Person) JSON.parseObject(str, Person.class);
		System.out.println(person.getId());
		System.out.println(person.getPassword());
		System.out.println(person.getUsernmae());
		System.out.println(person.getSex());
	}
}

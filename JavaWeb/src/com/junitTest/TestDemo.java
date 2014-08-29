package com.junitTest;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestDemo {

	@Test
	public void test1() {
		System.out.println("---------------");
	}

	@Test
	public void test2() {
		String str = "新建文本文档.txt";
		String[] s = str.split("\\.");
		System.out.println(s[0]);
		System.out.println(s[1]);
	}

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("zhangsan");
		test3(person);
	}

	private static void test3(Object object) {
		//getFields  表示可以访问的字段的数据
		//getDeclaredFields  表示所有字段组成的数组
		Field[] field = object.getClass().getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			Field f = field[i];
			try {
				f.setAccessible(true);
				System.out.println("字段名字" + f.getName() + "| 字段类型 "
						+ f.getType() + "| 字段的值" + f.get(object));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

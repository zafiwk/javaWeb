package com.junitTest;

import org.junit.Test;

public class SeTest {

	@Test
	public void test1() {
		System.out.println("---------------");
	}
	@Test
	public  void test2()
	{
		String str="新建文本文档.txt";
		String[]  s=str.split("\\.");
		System.out.println(s[0]);
		System.out.println(s[1]);
	}
}

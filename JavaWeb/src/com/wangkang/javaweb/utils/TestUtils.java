package com.wangkang.javaweb.utils;

import org.junit.Test;

public class TestUtils {
	@Test
	public void test1() {
		System.out.println(DateUtils.getDateNoUnderline());
	}

	@Test
	public void test2() {
		for(int i=0;i<10;i++){
		System.out.println(NumberUtils.getRandomByEight());
		}
	}
	@Test
	public void test3() {
	
	}
}

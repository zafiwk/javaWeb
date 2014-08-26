
package com.wangkang.javaweb.utils;

import java.util.Random;

/**
 * @author WangKang
 *  用来处理数字的工具类
 *
 */
public class NumberUtils {

	//java中产生随机数的方式有两种
	//1.Math.random()
	//2.Random 对象
	public static  int  getRandomByEight()
	{
		Random random=new Random();
		int i=0;
		for(int j=0;j<8;j++)
			i=i*10+random.nextInt(8)+1;
		return i;
	}
}

package com.wangkang.se.array;

import java.util.Arrays;

public class TestArray
{
   public  static void   main(String[]  args){
	  String[]  arr=new String[4];
	  arr[0] =" ";
	  arr[1]="a";
	  arr[2]="b";
	  arr[3]="c";
	  String[] arr1=Arrays.copyOf(arr, 4);
	  System.out.println(Arrays.toString(arr1));
	  String[] arr2=new  String[4];
	  //对应的参数  需要复制的对象  开始复制的下标   目标数组  目标位置的其实位置  需要复制的数组的长度
	  System.arraycopy(arr, 0, arr2, 0, arr.length);
	  System.out.println(Arrays.toString(arr2));
   }
}

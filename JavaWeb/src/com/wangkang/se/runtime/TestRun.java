package com.wangkang.se.runtime;

import java.util.ArrayList;
import java.util.List;

public class TestRun
{
  public  static void  main(String[] args){
	  Runtime runtime=Runtime.getRuntime();
	  System.out.println("运行CG程序回收内存");
	  runtime.gc();
	  List<String> list=new ArrayList<String>();
	  list.add("11111111111");
	  list.add("11111111111");
	  list.add("11111111111");
	  list.add("11111111111");
	  list.add("11111111111");
	  list.add("11111111111");
	  System.out.println("返回 Java 虚拟机试图使用的最大内存量:  "+runtime.maxMemory()/1024/1024);
	  System.out.println("返回 Java 虚拟机中的内存总量:   "+runtime.totalMemory()/1024/1024);
	  System.out.println("返回 Java 虚拟机中的空闲内存量:  "+runtime.freeMemory()/1024/1024);
	 System.out.println("System.currentTimeMillis():"+System.currentTimeMillis());
  }
}

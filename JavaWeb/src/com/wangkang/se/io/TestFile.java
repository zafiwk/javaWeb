package com.wangkang.se.io;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class TestFile
{
	String url = "src\\com\\wangkang\\se\\io";
	String fileName = "TestFile.properties";
	File file = new File(url, fileName);
	TestFileIO fileIo = new TestFileIO(file);

	//向文件中写入Map值
	@Test
	public void test1()
	{
		try
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("username", "wangkang");
			map.put("password", "wangkang");
			map.put("sex", "男");
			fileIo.write(map);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	//读取文件中的Map
	@Test
	public   void test2()
	{
		try
		{
			Map<String,String>  map=fileIo.reader(file);
			Iterator<Entry<String,String>>   it=map.entrySet().iterator();
			while(it.hasNext())
			{
				Entry<String,String> entry=it.next();
				System.out.println(entry.getKey()+"="+entry.getValue());
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

package com.wangkang.se.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TestFileIO
{
	private File file = null;

	public TestFileIO(File file)
	{
		this.file = file;
	}

	public void write(Map<String, String> map)
			throws UnsupportedEncodingException, IOException
	{
		FileOutputStream fos = new FileOutputStream(file, true);
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext())
		{
			Entry<String, String> entry = it.next();
			String str = entry.getKey() + "=" + entry.getValue();
			fos.write(str.getBytes("UTF-8"));
			fos.write("\n".getBytes("UTF-8"));
		}
		fos.flush();
		fos.close();
	}
	
	public  Map<String,String> reader(File file) throws IOException
	{
		Map<String,String>  map=new HashMap<String,String>();
		FileInputStream fis=new FileInputStream(file);
		Reader reader= new InputStreamReader(fis);
		BufferedReader  br=new BufferedReader(reader);
		String str=null;
		while((str=br.readLine())!=null)
		{
			String[]  strArray=str.split("\\=");
			map.put(strArray[0], strArray[1]);
		}
		br.close();
		return  map;
	}
}

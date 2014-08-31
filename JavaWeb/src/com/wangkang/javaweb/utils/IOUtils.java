package com.wangkang.javaweb.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*
 * 针对IO的Utils
 */
public class IOUtils
{
 public static void copy(InputStream  is,OutputStream os) throws IOException
 {
	 byte[]  b=new byte[1024*1024];
	 int k=-1;
	 while((k=is.read(b))>-1)
	 {
		 os.write(b, 0, k);
	 }
 }
}

package com.wangkang.javaweb.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.jsp.JspWriter;

public class MyConstPageWriter extends JspWriter
{

	private PrintWriter pw;

	public MyConstPageWriter(String fileName)
	{
		super(JspWriter.DEFAULT_BUFFER, false);
		try
		{
			pw = new PrintWriter(fileName, "UTF-8");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void newLine() throws IOException
	{
		
	}

	@Override
	public void print(boolean b) throws IOException
	{
		pw.print(b);
	}

	@Override
	public void print(char c) throws IOException
	{
		pw.print(c);
	}

	@Override
	public void print(int i) throws IOException
	{
		pw.print(i);
	}

	@Override
	public void print(long l) throws IOException
	{
		pw.print(l);
	}

	@Override
	public void print(float f) throws IOException
	{
		pw.print(f);
	}

	@Override
	public void print(double d) throws IOException
	{
		pw.print(d);
	}

	@Override
	public void print(char[] s) throws IOException
	{
		pw.print(s);
	}

	@Override
	public void print(String s) throws IOException
	{
		pw.print(s);
	}

	@Override
	public void print(Object obj) throws IOException
	{
		pw.print(obj);
	}

	@Override
	public void println() throws IOException
	{
		pw.println();
	}

	@Override
	public void println(boolean x) throws IOException
	{
			pw.println(x);
	}

	@Override
	public void println(char x) throws IOException
	{
		pw.println(x);
	}

	@Override
	public void println(int x) throws IOException
	{
		pw.println(x);
	}

	@Override
	public void println(long x) throws IOException
	{
		pw.println(x);
	}

	@Override
	public void println(float x) throws IOException
	{
		pw.println(x);
	}

	@Override
	public void println(double x) throws IOException
	{	
		pw.println(x);
	}

	@Override
	public void println(char[] x) throws IOException
	{
		pw.println(x);
	}

	@Override
	public void println(String x) throws IOException
	{
		pw.println(x);
	}

	@Override
	public void println(Object x) throws IOException
	{
		pw.println(x);
	}

	@Override
	public void clear() throws IOException
	{
	
	}

	@Override
	public void clearBuffer() throws IOException
	{
	  
	}

	@Override
	public void flush() throws IOException
	{
       pw.flush();
	}

	@Override
	public void close() throws IOException
	{
	   pw.close();
	}

	@Override
	public int getRemaining()
	{
		return 0;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException
	{
       pw.write(cbuf, off, len);
	}

}

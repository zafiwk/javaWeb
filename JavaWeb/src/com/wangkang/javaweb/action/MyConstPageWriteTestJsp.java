package com.wangkang.javaweb.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangkang.javaweb.utils.MyConstPageWriter;
import com.wangkang.javaweb.utils.WebUtils;

public class MyConstPageWriteTestJsp extends HttpServlet
{

	public void destroy()
	{
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		WebUtils  webUtils=WebUtils.getInstance(request, response);
		//String fileName = "ConstPageName";   // 生成的静态页面文件名
     	//第一次
     	//判断是否需要跟新缓存
     	//如果需要跟新缓存
		/*MyConstPageWriter out = new MyConstPageWriter(request.getServletContext().getRealPath(fileName));
		System.out.println(request.getServletContext().getRealPath(fileName));
     	out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
        out.println("<H1>这是一个缓存页面<H1>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
	  	out.close(); 
 	  	response.sendRedirect(fileName);*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request,response);
	}


	public void init() throws ServletException
	{
		
	}

}

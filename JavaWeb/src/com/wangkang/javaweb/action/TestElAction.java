package com.wangkang.javaweb.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangkang.javaweb.utils.WebUtils;

public class TestElAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebUtils  webUtils=WebUtils.getInstance(request, response);
		request.setAttribute("requestMessgae", "这是request传过来的消息");
		webUtils.getSession().setAttribute("sessionMessage", "这是session传过来的消息");
		//RequestDispatcher是针对应用的跳转/指的是根目录
		webUtils.sendRedirectByreRequest("/test.jsp");
	}

	public void init() throws ServletException {
	}

}

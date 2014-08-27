package com.wangkang.javaweb.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//工具对象
public class WebUtils {

	// 用来访问的路劲是否需要IO压缩
	List<String> list = new ArrayList<>();
	// 处理request对象
	private HttpServletRequest request = null;
	// 处理response对象
	private HttpServletResponse response = null;
	// 处理session
	private HttpSession session = null;
	// 处理Cookie
	private Cookie[] cookie = null;
	// 得到当前Web容器的root的路劲
	private String webRootUrl = null;
	// 得到真实路劲用于上传文件
	private String realUrl = null;
    private static  WebUtils webUtils=null;
    public  static  synchronized WebUtils  getInstance(HttpServletRequest request, HttpServletResponse response)
    {
    	if(webUtils==null)
    	{
    		webUtils=new WebUtils(request,response);
    		return webUtils;
    	}
    	else
    		 return webUtils;
    }
	private WebUtils(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		// request.getScheme() 协议
		// request.getServerName() 服务器名字
		// request.getServerPort() 端口号
		// request.getContextPath() request提交的容器对象的路劲
		this.webRootUrl = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath();
		this.realUrl = request.getServletContext().getRealPath("/");
		list.add("JSP");
		list.add("HTML");
		list.add("CSS");
		list.add("PNG");

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpSession getSession() {
		return session;
	}

	public Cookie[] getCookie() {
		cookie = request.getCookies();
		return cookie;
	}

	public void setCookie(Cookie cookie) {
		response.addCookie(cookie);
	}

	public String getWebRootUrl() {
		return webRootUrl;
	}

	public void closeSession() {
		this.session.invalidate();
	}

	public void deleteCookie(String coolieName) {
		// cookie的路劲默认是/
		// 如果设置了路劲在删除的时候要保持路劲一致
		if (this.cookie == null)
			return;
		else {
			for (Cookie cookie : this.cookie) {
				String name = cookie.getName();
				if (name.equals(coolieName)) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}

			}
		}
	}

	public String getRealUrl() {
		return realUrl;
	}

	/*
	 * @param url url访问tomcat的绝对路径
	 */
	public void sendRedirectByreResponse(String url) throws IOException {
		response.sendRedirect(url);
	}

	/*
	 * @param url url /开头相对应用的根目录
	 */
	public void sendRedirectByreRequest(String url) throws IOException,
			ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(this.request, this.response);
	}

	
}

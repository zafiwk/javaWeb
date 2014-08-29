package com.junitTest;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
//ServletRequestWrapper采用了装饰模式增强了ServletRequest对象，如果需要修改某个方法就认为的覆盖那个方法
public class TestServlet extends ServletRequestWrapper{

	public TestServlet(ServletRequest request) {
		super(request);
	}

}

class TestHttpServletRequestWrapper extends HttpServletRequestWrapper{

	public TestHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
}

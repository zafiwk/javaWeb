package com.wangkang.javaweb.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

import com.wangkang.javaweb.utils.FileUpLoadUtils;




public class FileUpLoadAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); 
		// Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		InputStream is = request.getInputStream();
		byte[] b = new byte[1024 * 1024];
		int i = -1;
		StringBuffer sb=new StringBuffer();
		while (((i = is.read(b)) > 0)) {
			sb.append(new String(b,0,i));
		}
		sb.trimToSize();
		System.out.println(sb.toString());
		-----------------------------16790983432052
		Content-Disposition: form-data; name="str"

		绗笁鏂瑰＋澶уか澹ぇ澶?
		-----------------------------16790983432052--*/
		String fileUrl=request.getServletContext().getRealPath("/file");
		try {
			FileUpLoadUtils.FileUpLoad(request, fileUrl);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		response.getWriter().write("文件:"+request.getAttribute("str")+"上传成功！！！！");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	public void init() throws ServletException {
	}

}

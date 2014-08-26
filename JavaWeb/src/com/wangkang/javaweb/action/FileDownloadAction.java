package com.wangkang.javaweb.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangkang.javaweb.utils.FileUpLoadUtils;

public class FileDownloadAction extends HttpServlet {

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
		String fileUrl=request.getServletContext().getRealPath("/file/0001.jpg");
		File file=new File(fileUrl);
		FileUpLoadUtils.FileDownload(response, file);
		
	}

	public void init() throws ServletException {
	}

}

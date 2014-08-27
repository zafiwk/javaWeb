package com.wangkang.javaweb.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

import com.wangkang.javaweb.utils.DateUtils;
import com.wangkang.javaweb.utils.FileUpLoadUtils;
import com.wangkang.javaweb.utils.WebUtils;

public class FileUpLoadAction extends HttpServlet {

	private List<String> list = new ArrayList<>();
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy();
		// Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * InputStream is = request.getInputStream(); byte[] b = new byte[1024 *
		 * 1024]; int i = -1; StringBuffer sb=new StringBuffer(); while (((i =
		 * is.read(b)) > 0)) { sb.append(new String(b,0,i)); } sb.trimToSize();
		 * System.out.println(sb.toString());
		 * -----------------------------16790983432052 Content-Disposition:
		 * form-data; name="str"
		 * 
		 * 绗笁鏂瑰＋澶уか澹ぇ澶? -----------------------------16790983432052--
		 */

		WebUtils webUtil = new WebUtils(request, response);
		String time = DateUtils.getDateNoUnderline();
		String fileUrl = webUtil.getRealUrl() + "WEB-INF\\file\\" + time;
		File file = new File(fileUrl);
		if (!file.isFile())
			file.mkdirs();
		try {
			FileUpLoadUtils.FileUpLoad(request, fileUrl, list);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		webUtil.sendRedirectByreRequest("/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	public void init() throws ServletException {
		String str = "GIF,TIF,JPG,JPEG,PNG,BMP,DOC,DOCX,WPS,PPT,PPTX,DPS,XLS,XLSX,ET,TXT,PDF,RAR,ZIP";
		String[] l = str.split("\\,");
		for (int i = 0; i < l.length; i++) {
			list.add(l[i]);
		}
	}

}

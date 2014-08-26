package com.wangkang.javaweb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUpLoadUtils {

	public static void FileUpLoad(HttpServletRequest request, String fileUrl) throws FileUploadException, IOException {
		//设置临时文件夹

		String tempUrl = request.getServletContext().getRealPath("/temp");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 100);
		// 设置上传文件的大小 默认10K

		factory.setRepository(new File(tempUrl));
		// 默认临时文件夹System.getProperty("java.io.tmpdir").

		// 创建ServletFileUpload对象

		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置上传编码

		// 解析request对象传过的来值

			List<FileItem> fileItems = upload.parseRequest(request);
			Iterator<FileItem> it = fileItems.iterator();
			while (it.hasNext()) {
				// 将传过来的值封装FileItem对象

				FileItem fi = it.next();
				if (fi.isFormField()) {
					// 这里转换成UTF-8

					String name = fi.getFieldName();
					String value = fi.getString("UTF-8");
					System.out.println("name的值是" + name + "----" + "value的值是"+ value);
					request.setAttribute(name, value);
				} else {
					//文件上传时候如果没有上过文件，就会得到一个InputStream 对象只不过内容是空是

					if (!fi.getName().equals("")) {
						//------------------------用于显示上传进度

						//ProgressListener  progressListener=new ProgressListener (){

						//	public void update(long pBytesRead, long pContentLength, int pItems) {

						//		System.out.println("到现在为止,  " + pBytesRead + " 字节已上传，总大小为 "

						//				  + pContentLength);

						//	}

						//};

						// 得到文件流

						InputStream is = fi.getInputStream();
						FileOutputStream fos = new FileOutputStream(new File(fileUrl, fi.getName()));
						byte buffer[] = new byte[1024];
						int len = 0;
						while ((len = is.read(buffer)) > 0) {
							fos.write(buffer, 0, len);
						}
						is.close();
						fos.close();
						fi.delete();
					}
				}
			}
		}
	
	
	public static  void  FileDownload(HttpServletResponse response,File  file) throws IOException
	{
		
		//Content-Disposition: 服务器通过这个头，告诉浏览器以下载方式打数据

		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(file.getName(),"UTF-8"));
		FileInputStream in = new FileInputStream(file);
		//设置MIME表示属于下载

		//response.setContentType("application/x-msdownload");

		int len = 0;
		byte buffer[] = new byte[1024];
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		in.close();
	}
}
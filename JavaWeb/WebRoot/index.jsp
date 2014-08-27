<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="<%=basePath%>servlet/FileUpLoadAction"    method="post"  enctype="multipart/form-data">
	    <input type="text"  name="str"/><br/>
	    <input type="file"  name="file"><br/>
	    <input  type="submit"  value="提交"/>
    </form>
    
    
    <a  href="${basePath }servlet/FileDownloadAction">文件下载</a><br/>
    ---------------------------------------------------------------<br/>
    <em>${message }</em><br/>
    -------------------------------------------------------------------<br/>
    <a  href="${pageContext.request.contextPath }/servlet/TestElAction">跳转进入test.jsp</a>
  </body>
</html>

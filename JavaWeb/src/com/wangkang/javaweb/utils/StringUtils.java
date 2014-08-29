package com.wangkang.javaweb.utils;

public class StringUtils {

	
	/*@author    王康
	 *@version   V1.0
	 *@see      
	 *@param     需要判断的字符串
	 *@return    如果字符串不为空返回的就是true
	 *@exception 没有异常
	 **/
	public  static  Boolean  isNotBlank(String str)
	{
		if(str!=null&&("").equals(str))
			return  true;
		else
			return false;
	}
	
	
	public static  Boolean isBlank(String str)
	{
		if(str==null||"".equals(str))
			return  true;
		else
			return false;
	}
}

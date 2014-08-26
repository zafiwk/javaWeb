package com.wangkang.javaweb.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 用于处理时间的工具类
 * 版本 v1.0
 * 作者 王康
 */
public class DateUtils {

	/** 年月日时分秒(无下划线) yyyyMMddHHmmss */
	private static final String dtLong = "yyyyMMddHHmmss";

	/** 完整时间 yyyy-MM-dd HH:mm:ss */
	private static final String simple = "yyyy-MM-dd HH:mm:ss";

	/** 年月日(无下划线) yyyyMMdd */
	private static final String dtShort = "yyyyMMdd";

	/** 年月日(下划线) yyyy-MM-dd */
	private static final String _dtShort = "yyyy-MM-dd";
	/*
	 * 获取系统当前日期(精确到毫秒),格式：yyyy-MM-dd HH:mm:ss
	 * 版本 v1.0 
	 */
	public  static  String getDateFormatter()
	{
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(simple);
		return df.format(date);
	}
	/*
	 * 以yyyy-MM-dd获取当前时间日期
	 */
	public static  String getDate()
	{
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(_dtShort);
		return  df.format(date);
	}
	/*
	 * 以yyyyMMdd获取当前时间
	 */
	public  static String  getDateNoUnderline()
	{
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtShort);
		return df.format(date);
	}
}

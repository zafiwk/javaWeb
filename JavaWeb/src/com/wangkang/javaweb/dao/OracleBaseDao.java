package com.wangkang.javaweb.dao;

import com.wangkang.javaweb.utils.DateBaseUtils;

public class OracleBaseDao   extends  DateBaseUtils{

	private static OracleBaseDao conn=null;
	private OracleBaseDao(String url, String classUrl, String username,
			String password) {
		super(url, classUrl, username, password);
	}
	
	public static synchronized  OracleBaseDao  getOracleBaseDaoInstance(String url, String classUrl, String username,
			String password)
	{
		if(conn==null)
		{
			conn=new OracleBaseDao(url,classUrl,username,password);
			return conn;
		}
		else
			return conn;
	}

}

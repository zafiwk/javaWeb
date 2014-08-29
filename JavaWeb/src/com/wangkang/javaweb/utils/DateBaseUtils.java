package com.wangkang.javaweb.utils;

/*
 * 数据库工具类继承使用
 * 提供了得到连接和关闭连接
 */
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateBaseUtils {

	private String url = null;
	private String classUrl = null;
	private String username = null;
	private String password = null;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public DateBaseUtils(String url, String classUrl, String username,
			String password) {
		this.url = url;
		this.classUrl = classUrl;
		this.username = username;
		this.password = password;
		try {
			Class.forName(classUrl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public String getClassUrl() {
		return classUrl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	protected void closeConn(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (conn != null)
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
					}
			}
		rs = null;
		ps = null;
		conn = null;
	}

	protected Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	// 向数据库添加数据
	protected void InsertValue(String sql, List<String> list, Object object) {
		try {
			Map<String, Object> map = doFiled(object);
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				ps.setObject(i, map.get(list.get(i)));
			}
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConn(conn, ps, rs);
		}
	}

	// 向数据库删除记录
	protected void DeleteValue(String sql, List<String> list, Object object) {
		Map<String, Object> map = doFiled(object);
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				ps.setObject(i, map.get(list.get(i)));
			}
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConn(conn, ps, rs);
		}
	}

	// 数据库修改记录
	protected void updateValue(String sql, List<String> list, Object object) {
		try {
			Map<String, Object> map = doFiled(object);
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				ps.setObject(i, map.get(list.get(i)));
			}
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConn(conn, ps, rs);
		}
	}
	/*
	 * 将object对象的属性值转化成Map
	 */
	private Map<String, Object> doFiled(Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] field = object.getClass().getDeclaredFields();
		for (Field f : field) {
			f.setAccessible(true);
			try {
				map.put(f.getName(), f.get(object));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;

	}

	/*
	 * 对于需要事务管理的时候，使用以下方法关闭
	 */
	protected void close(PreparedStatement ps, ResultSet rs) {
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
	}
}

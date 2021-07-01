package com.itwn.homework.mysqltask;

import java.sql.*;

public class Myutils {
	private static String url="jdbc:mysql://localhost:3306/tc42";
	private static String user="root";
	private static String password="123456";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("校验失败");
		}
	}
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}
	public static void release(Connection conn, PreparedStatement ps, ResultSet rs){
		try {
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null){
				ps.close();
			}
			if (conn!=null){
				conn.close();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	public static void release(Connection conn, PreparedStatement ps){
		release(conn,ps,null);
	}

}

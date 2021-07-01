package com.itwn.test.mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("加载失败");
		}
		String url="jdbc:mysql://localhost:3306/tc42";
		String user="root";
		String password="123456";
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}

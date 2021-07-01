package com.itwn.test.druidtest;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.SQLException;

public class DruidTest {
	public static void main(String[] args) throws SQLException {
		//什么是数据数连接池：管理数据库连接对象
		//什么是线程池 ：管理线程对象
		//目的都是减少 频繁创建销毁对象导致的性能消耗过大

		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/tc42");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setInitialSize(5);//初始准备5个数据库连接对象
		dataSource.setMaxActive(20);//数据库最大可以存在20个连接对象

		DruidPooledConnection conn = dataSource.getConnection();


		conn.close();
	}
}

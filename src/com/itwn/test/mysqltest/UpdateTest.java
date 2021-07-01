package com.itwn.test.mysqltest;

import com.itwn.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {
	public static void main(String[] args) throws SQLException {

		Connection conn= DBUtil.getConnection();
		String sql="update t_emp set name=?,title=?,salary=? where id=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setObject(1,"张元");
		ps.setObject(2,"公关");
		ps.setObject(3,"50000");
		ps.setObject(4,"16");
		int rows=ps.executeUpdate();
		System.out.println(rows>0?"修改成功":"修改失败");

		DBUtil.release(conn,ps);
	}
}

package com.itwn.test.mysqltest;

import com.itwn.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTest {
	public static void main(String[] args) throws SQLException {
		Connection conn= DBUtil.getConnection();
		String sql="insert into t_emp(tno,name,gender,birthday,salary,title,manager_id,dept_id)" +
				"value(?,?,?,?,?,?,?,? ) ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setObject(1,"WNSH0021");
		ps.setObject(2,"武则天");
		ps.setObject(3,"女");
		ps.setObject(4,"2002-02-02");
		ps.setObject(5,100000);
		ps.setObject(6,"女帝");
		ps.setObject(7,null);
		ps.setObject(8,1);
		int rows=ps.executeUpdate();
		System.out.println(rows>0?"修改成功":"修改失败");

		DBUtil.release(conn,ps);
	}
}

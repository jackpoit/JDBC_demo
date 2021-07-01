package com.itwn.homework.mysqltask;

import com.itwn.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DelTest {
	public static void main(String[] args) {
		//1.删除
		int id=21;
		String sql="delete from t_emp where id=?";
		Connection conn= DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1,id);
			System.out.println(ps.executeUpdate()>0?"删除成功":"删除失败");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		DBUtil.release(conn,ps);



	}
}

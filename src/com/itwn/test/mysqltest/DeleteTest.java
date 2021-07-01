package com.itwn.test.mysqltest;

import com.itwn.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

	public static void main(String[] args) {
		int[] nums={15,18};
		int rows=delete(nums);
		System.out.println(rows>0?"删除成功":"删除失败");
	}
	public static int delete(int...ids){
		String sql="delete from t_emp where id in (";
		for (int i=0;i<ids.length;i++){
			sql+="?";
			if (i!=ids.length-1)
				sql+=",";

		}
		sql+=")";
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn= DBUtil.getConnection();
			assert conn != null;
			ps = conn.prepareStatement(sql);
			for (int i=0;i<ids.length;i++){
				ps.setObject(i+1,ids[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		finally {
			DBUtil.release(conn,ps);
		}
		return 0;
	}

}

package com.itwn.test.mysqltest;

import com.itwn.entity.Employee;
import com.itwn.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class QueryTest02 {

	/**
	 * 根据id来查询指定的员工
	 * @param id  主键id
	 * @return  员工对象  null 没有查询到数据
	 * @throws SQLException
	 */
	public static Employee findById(int id) throws SQLException {
		Connection conn= DBUtil.getConnection();
		String sql="SELECT id,tno,name,gender,birthday,title,salary,manager_id,dept_id from t_emp where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setObject(1,id);
		ResultSet rs = ps.executeQuery();
		Employee emp=null;
		if (rs.next()){
			int id1 = rs.getInt("id");
			String tno = rs.getString("tno");
			String name = rs.getString("name");

			String gender = rs.getString("gender");
			java.sql.Date time = rs.getDate("birthday");
			Date birthday = new Date(time.getTime());
			BigDecimal salary = rs.getBigDecimal("salary");
			String title = rs.getString("title");
			int managerId = rs.getInt("manager_id");
			int deptId = rs.getInt("dept_id");
			emp = new Employee(id1, tno, name, gender, birthday, title, salary, managerId, deptId);
		}
			DBUtil.release(conn,ps,rs);
			return emp;
	}


	public static void main(String[] args) {
		Employee emp=null;
		try {
			emp=findById(19);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		if (emp!=null){
			System.out.println(emp);
		}
	}
}

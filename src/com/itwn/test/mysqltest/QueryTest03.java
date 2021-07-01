package com.itwn.test.mysqltest;

import com.itwn.entity.Employee;
import com.itwn.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryTest03 {


	public static List<Employee> findAll() throws SQLException {
		Connection conn= DBUtil.getConnection();
		String sql="SELECT id,tno,name,gender,birthday,title,salary,manager_id,dept_id from t_emp";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Employee emp=null;
		List<Employee> list=new ArrayList<>();
		while (rs.next()){
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
			list.add(emp);
		}
		DBUtil.release(conn,ps,rs);
		return list.isEmpty()?null:list;
	}

	public static void main(String[] args) throws SQLException {
		List<Employee> list = findAll();
		if (list!=null) {
			for (Employee emp : list) {
				System.out.println(emp);
			}
		}
	}
}

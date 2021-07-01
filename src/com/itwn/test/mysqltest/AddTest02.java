package com.itwn.test.mysqltest;

import com.itwn.entity.Employee;
import com.itwn.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AddTest02 {

	public static void main(String[] args) {
		Employee e=new Employee("WNSH0022","赵云","男",new Date(),"将军",new BigDecimal("20000"),1,null);
		int rows= 0;
		try {
			rows = add(e);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		System.out.println(rows>0?"添加成功":"添加失败");
	}


	/**
	 * 将java对象员工传入数据库
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public static int add(Employee emp)  throws SQLException {

		Connection conn= DBUtil.getConnection();
		String sql="insert into t_emp(tno,`name`,gender,birthday,salary,title,manager_id,dept_id)" +
				"value(?,?,?,?,?,?,?,? ) ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setObject(1,emp.getTno());
		ps.setObject(2,emp.getName());
		ps.setObject(3,emp.getGender());
		ps.setObject(4,emp.getBirthday());
		ps.setObject(5,emp.getSalary());
		ps.setObject(6,emp.getTitle());
		ps.setObject(7,emp.getManagerid());
		ps.setObject(8,emp.getDeptid());
		int rows=ps.executeUpdate();
		DBUtil.release(conn,ps);
		return rows;
	}
}

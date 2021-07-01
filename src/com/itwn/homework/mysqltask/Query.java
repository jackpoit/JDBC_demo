package com.itwn.homework.mysqltask;

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

public class Query {
	public static void main(String[] args) throws SQLException {

		Connection conn= DBUtil.getConnection();
		String sql="select * from t_emp";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		List<Employee> list=new ArrayList<>();
		while (rs.next()){
			Integer id=rs.getInt(1);
			String tno=rs.getString(2);
			String name=rs.getString(3);
			 String gender=rs.getString(4);
			java.sql.Date date=rs.getDate(5);
			 Date birthday=new Date(date.getTime());
			 String title=rs.getString(6);
			 BigDecimal salary=rs.getBigDecimal(7);
			 Integer managerId=rs.getInt(8);
			 Integer deptId=rs.getInt(9);
			 list.add(new Employee(id, tno, name, gender, birthday, title, salary, managerId, deptId));
		}
		DBUtil.release(conn,ps,rs);
		for (Employee e:list) {
			System.out.println(e);
		}
	}
}

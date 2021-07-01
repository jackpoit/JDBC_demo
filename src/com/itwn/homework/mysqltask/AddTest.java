package com.itwn.homework.mysqltask;

import com.itwn.entity.Employee;
import com.itwn.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AddTest {
	public static void main(String[] args) {
		//2.add
		Employee emp=new Employee("WNSH0025","哈密瓜","女",new Date(),"queen",new BigDecimal("100000"),1,null);

		Connection conn= DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql="insert into t_emp value(null,?,?,?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setObject(1,emp.getTno());
			ps.setObject(2,emp.getName());
			ps.setObject(3,emp.getGender());
			ps.setObject(4,emp.getBirthday());
			ps.setObject(5,emp.getTitle());
			ps.setObject(6,emp.getSalary());
			ps.setObject(7,emp.getManagerid());
			ps.setObject(8,emp.getDeptid());
			System.out.println(ps.executeUpdate()>0?"添加成功":"添加失败");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		DBUtil.release(conn,ps);
	}


}

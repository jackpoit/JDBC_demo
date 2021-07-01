package com.itwn.dao.impl;

import com.itwn.dao.EmployeeDAO;
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

public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public int add(Employee emp) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO t_emp(tno,name,gender,birthday,salary,title,manager_id,dept_id)" +
				"VALUE(?,?,?,?,?,?,?,? ) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, emp.getTno());
		ps.setObject(2, emp.getName());
		ps.setObject(3, emp.getGender());
		ps.setObject(4, emp.getBirthday());
		ps.setObject(5, emp.getSalary());
		ps.setObject(6, emp.getTitle());
		ps.setObject(7, emp.getManagerid());
		ps.setObject(8, emp.getDeptid());
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public int deleteById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM t_emp WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public int update(Employee emp) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE t_emp SET tno=?,name=?,gender=?,birthday=?,salary=?,title=?,manager_id=?,dept_id=? " +
				"WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, emp.getTno());
		ps.setObject(2, emp.getName());
		ps.setObject(3, emp.getGender());
		ps.setObject(4, emp.getBirthday());
		ps.setObject(5, emp.getSalary());
		ps.setObject(6, emp.getTitle());
		ps.setObject(7, emp.getManagerid());
		ps.setObject(8, emp.getDeptid());
		ps.setObject(9, emp.getId());
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public Employee findById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,tno,name,gender,birthday,title,salary,manager_id,dept_id from t_emp where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		ResultSet rs = ps.executeQuery();
		Employee emp = null;
		while (rs.next()) {            //ORM(Object Relational Mapping)
			int ids = rs.getInt("id");
			String tno = rs.getString("tno");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			java.sql.Date time = rs.getDate("birthday");
			Date birthday = time != null ? new Date(time.getTime()) : null;
			BigDecimal salary = rs.getBigDecimal("salary");
			String title = rs.getString("title");
			int managerId = rs.getInt("manager_id");
			int deptId = rs.getInt("dept_id");
			emp = new Employee(ids, tno, name, gender, birthday, title, salary, managerId, deptId);
		}
		DBUtil.release(conn, ps, rs);
		return emp;
	}

	@Override
	public List<Employee> findAll() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,tno,name,gender,birthday,title,salary,manager_id,dept_id from t_emp";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Employee emp = null;
		List<Employee> list = new ArrayList<>();
		while (rs.next()) {
			int id1 = rs.getInt("id");
			String tno = rs.getString("tno");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			java.sql.Date time = rs.getDate("birthday");
			Date birthday = time != null ? new Date(time.getTime()) : null;
			BigDecimal salary = rs.getBigDecimal("salary");
			String title = rs.getString("title");
			int managerId = rs.getInt("manager_id");
			int deptId = rs.getInt("dept_id");
			emp = new Employee(id1, tno, name, gender, birthday, title, salary, managerId, deptId);
			list.add(emp);
		}
		DBUtil.release(conn, ps, rs);
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<Employee> findLike(String str) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,tno,name,gender,birthday,title,salary,manager_id,dept_id from t_emp WHERE name LIKE ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, str);
		ResultSet rs = ps.executeQuery();
		Employee emp = null;
		List<Employee> list = new ArrayList<>();
		while (rs.next()) {
			int id1 = rs.getInt("id");
			String tno = rs.getString("tno");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			java.sql.Date time = rs.getDate("birthday");
			Date birthday = time != null ? new Date(time.getTime()) : null;
			BigDecimal salary = rs.getBigDecimal("salary");
			String title = rs.getString("title");
			int managerId = rs.getInt("manager_id");
			int deptId = rs.getInt("dept_id");
			emp = new Employee(id1, tno, name, gender, birthday, title, salary, managerId, deptId);
			list.add(emp);
		}
		DBUtil.release(conn, ps, rs);
		return list.isEmpty() ? null : list;
	}
}

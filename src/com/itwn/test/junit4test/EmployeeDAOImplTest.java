package com.itwn.test.junit4test;

import com.itwn.dao.impl.EmployeeDAOImpl;
import com.itwn.entity.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class EmployeeDAOImplTest {
	private EmployeeDAOImpl edi;
	@Before
	public void init(){
		edi=new EmployeeDAOImpl();
	}

	@Test
	public void add() {
		try {
			int result=edi.add(new Employee("WNSH0025","哈密瓜","女",null,
					"king",new BigDecimal("15000"),1,null));
			Assert.assertEquals(10,result);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void deleteById() {
		try {
			int rows=edi.deleteById(26);
			System.out.println(rows==0?"失败":"成功");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void update() {
		try {
			int rows=edi.update(new Employee(31,"WNSH0028","娃哈哈","男",new Date(2012-1900,11,12),
					"king",new BigDecimal("15000"),1,null));
			System.out.println(rows==0?"失败":"成功");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	@Test
	public void findById() {
		try {
			Employee emp=edi.findById(14);
			System.out.println(emp);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void findAll() {
		try {
			List<Employee> list=edi.findAll();
			System.out.println(list);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void findLikeName(){
		try {
			List<Employee> list=edi.findLike("%三%");
			System.out.println(list);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
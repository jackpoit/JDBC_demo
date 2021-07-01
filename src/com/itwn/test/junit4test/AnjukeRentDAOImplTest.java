package com.itwn.test.junit4test;

import com.itwn.dao.AnjukeRentDAO;
import com.itwn.dao.impl.AnjukeRentDAOImpl;
import com.itwn.entity.AnjukeRent;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class AnjukeRentDAOImplTest {
	private AnjukeRentDAO aji;

	@Before
	public void init(){
		aji=new AnjukeRentDAOImpl();
	}

	@Test
	public void add() {
		try {
			int result=aji.add(new AnjukeRent("浦东新区","4号线",new BigDecimal("1900"),
					"四室","合租","普通住宅","朝北"));
			System.out.println(result>0?"成功":"失败");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void deleteById() {
		try {
			int result=aji.deleteById(29);
			System.out.println(result>0?"成功":"失败");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void update() {
		try {
			int result=aji.update(new AnjukeRent(28,"浦东新区","4号线",new BigDecimal("1900"),
					"四室","合租","普通住宅","朝北"));
			System.out.println(result>0?"成功":"失败");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void findById() {
		try {
			System.out.println(aji.findById(18));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void findAll() {
		try {
			List<AnjukeRent> list=aji.findAll();
			System.out.println(list);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void findLikeName() {
		try {
			List<AnjukeRent> list=aji.findLike("徐%");
			System.out.println(list);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
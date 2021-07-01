package com.itwn.test.junit4test;

import com.itwn.dao.GeneralDAO;
import com.itwn.dao.GoodsDAO;
import com.itwn.dao.impl.GoodsDAOImpl;
import com.itwn.entity.AnjukeRent;
import com.itwn.entity.Goods;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class GoodsDAOImplTest {
	private GoodsDAO gdi;

	@Before
	public void init(){
		gdi=new GoodsDAOImpl();
	}

	@Test
	public void add() {
		try {
			int result=gdi.add(new Goods("三星s10","啦啦啦",new BigDecimal("6900"),10,5));
			System.out.println(result>0?"成功":"失败");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void deleteById() {
		try {
			int result=gdi.deleteById(22);
			System.out.println(result>0?"成功":"失败");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void update() {
		try {
			int result=gdi.update(new Goods(20,"三星s10","啦啦啦",new BigDecimal("6900"),10,5));
			System.out.println(result>0?"成功":"失败");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void findById() {
		try {
			System.out.println(gdi.findById(33));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void findAll() {
		try {
			List<Goods> list=gdi.findAll();
			System.out.println(list);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Test
	public void findLike() {
		try {
			List<Goods> list=gdi.findLike("%Apple%");
			System.out.println(list);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
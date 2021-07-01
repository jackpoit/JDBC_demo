package com.itwn.dao.impl;

import com.itwn.dao.GoodsDAO;
import com.itwn.entity.Goods;
import com.itwn.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO {
	@Override
	public int add(Goods goods) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO t_goods(pname,description,price,stock,sales)" +
				"VALUE(?,?,?,?,?) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, goods.getpName());
		ps.setObject(2, goods.getDescription());
		ps.setObject(3, goods.getPrice());
		ps.setObject(4, goods.getStock());
		ps.setObject(5, goods.getSales());
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public int deleteById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM t_goods WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public int update(Goods goods) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE t_goods SET pname=?,description=?,price=?,stock=?,sales=? WHERE id=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, goods.getpName());
		ps.setObject(2, goods.getDescription());
		ps.setObject(3, goods.getPrice());
		ps.setObject(4, goods.getStock());
		ps.setObject(5, goods.getSales());
		ps.setObject(6, goods.getId());
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public Goods findById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,pname,description,price,stock,sales FROM t_goods WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		ResultSet rs = ps.executeQuery();
		Goods goods=null;
		while (rs.next()) {
			Integer ids=rs.getInt("id");
			String pName=rs.getString("pname");
			String description=rs.getString("description");
			BigDecimal price=rs.getBigDecimal("price");
			Integer stock=rs.getInt("stock");
			Integer sales=rs.getInt("sales");
			goods=new Goods(ids,pName,description,price,stock,sales);
		}
		DBUtil.release(conn, ps, rs);
		return goods;
	}

	@Override
	public List<Goods> findAll() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,pname,description,price,stock,sales FROM t_goods ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Goods goods=null;
		List<Goods> list=new ArrayList<>();
		while (rs.next()) {
			Integer ids=rs.getInt("id");
			String pName=rs.getString("pname");
			String description=rs.getString("description");
			BigDecimal price=rs.getBigDecimal("price");
			Integer stock=rs.getInt("stock");
			Integer sales=rs.getInt("sales");
			goods=new Goods(ids,pName,description,price,stock,sales);
			list.add(goods);
		}
		DBUtil.release(conn, ps, rs);
		return list.isEmpty()?null:list;
	}

	@Override
	public List<Goods> findLike(String str) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,pname,description,price,stock,sales FROM t_goods WHERE pname LIKE ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1,str);
		ResultSet rs = ps.executeQuery();
		Goods goods=null;
		List<Goods> list=new ArrayList<>();
		while (rs.next()) {
			Integer ids=rs.getInt("id");
			String pName=rs.getString("pname");
			String description=rs.getString("description");
			BigDecimal price=rs.getBigDecimal("price");
			Integer stock=rs.getInt("stock");
			Integer sales=rs.getInt("sales");
			goods=new Goods(ids,pName,description,price,stock,sales);
			list.add(goods);
		}
		DBUtil.release(conn, ps, rs);
		return list.isEmpty()?null:list;
	}
}

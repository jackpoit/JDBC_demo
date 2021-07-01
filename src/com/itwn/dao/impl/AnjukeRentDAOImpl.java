package com.itwn.dao.impl;

import com.itwn.dao.AnjukeRentDAO;
import com.itwn.entity.AnjukeRent;
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

public class AnjukeRentDAOImpl implements AnjukeRentDAO {
	@Override
	public int add(AnjukeRent ajr) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO anjuke_rent(zone,train_line,rent_money,room,rent_type,layout,direction)" +
				"VALUE(?,?,?,?,?,?,?) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, ajr.getZone());
		ps.setObject(2, ajr.getTrainLine());
		ps.setObject(3, ajr.getRentMoney());
		ps.setObject(4, ajr.getRoom());
		ps.setObject(5, ajr.getRentType());
		ps.setObject(6, ajr.getLayout());
		ps.setObject(7, ajr.getDirection());
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public int deleteById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM anjuke_rent WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public int update(AnjukeRent ajr) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE anjuke_rent SET zone=?,train_line=?,rent_money=?,room=?," +
				"rent_type=?,layout=?,direction=? WHERE id=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, ajr.getZone());
		ps.setObject(2, ajr.getTrainLine());
		ps.setObject(3, ajr.getRentMoney());
		ps.setObject(4, ajr.getRoom());
		ps.setObject(5, ajr.getRentType());
		ps.setObject(6, ajr.getLayout());
		ps.setObject(7, ajr.getDirection());
		ps.setObject(8, ajr.getId());

		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public AnjukeRent findById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,zone,train_line,rent_money,room,rent_type,layout,direction from anjuke_rent where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		ResultSet rs = ps.executeQuery();
		AnjukeRent ajr = null;
		while (rs.next()) {
			Integer ids = rs.getInt("id");
			String zone = rs.getString("zone");
			String trainLine = rs.getString("train_line");
			BigDecimal rentMoney = rs.getBigDecimal("rent_money");
			String room = rs.getString("room");
			String rentType = rs.getString("rent_type");
			String layout = rs.getString("layout");
			String direction = rs.getString("direction");
			ajr = new AnjukeRent(ids, zone, trainLine, rentMoney, room, rentType, layout, direction);
		}
		DBUtil.release(conn, ps, rs);
		return ajr;
	}

	@Override
	public List<AnjukeRent> findAll() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,zone,train_line,rent_money,room,rent_type,layout,direction from anjuke_rent";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		AnjukeRent ajr = null;
		List<AnjukeRent> list=new ArrayList<>();
		while (rs.next()) {
			Integer ids = rs.getInt("id");
			String zone = rs.getString("zone");
			String trainLine = rs.getString("train_line");
			BigDecimal rentMoney = rs.getBigDecimal("rent_money");
			String room = rs.getString("room");
			String rentType = rs.getString("rent_type");
			String layout = rs.getString("layout");
			String direction = rs.getString("direction");
			ajr = new AnjukeRent(ids, zone, trainLine, rentMoney, room, rentType, layout, direction);
			list.add(ajr);
		}
		DBUtil.release(conn, ps, rs);
		return list.isEmpty()?null:list;
	}

	@Override
	public List<AnjukeRent> findLike(String str) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,zone,train_line,rent_money,room,rent_type,layout,direction from anjuke_rent WHERE zone LIKE ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, str);
		ResultSet rs = ps.executeQuery();
		AnjukeRent ajr = null;
		List<AnjukeRent> list=new ArrayList<>();
		while (rs.next()) {
			Integer ids = rs.getInt("id");
			String zone = rs.getString("zone");
			String trainLine = rs.getString("train_line");
			BigDecimal rentMoney = rs.getBigDecimal("rent_money");
			String room = rs.getString("room");
			String rentType = rs.getString("rent_type");
			String layout = rs.getString("layout");
			String direction = rs.getString("direction");
			ajr = new AnjukeRent(ids, zone, trainLine, rentMoney, room, rentType, layout, direction);
			list.add(ajr);
		}
		DBUtil.release(conn, ps, rs);
		return list.isEmpty()?null:list;
	}
}

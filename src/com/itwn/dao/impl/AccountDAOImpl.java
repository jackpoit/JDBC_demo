package com.itwn.dao.impl;

import com.itwn.dao.AccountDAO;
import com.itwn.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * AccountDAO实现类(JDBC相关操作)
 */
public class AccountDAOImpl implements AccountDAO {
	@Override
	public int saveMoney(Connection conn,String name, BigDecimal money) throws SQLException {
		String sql="UPDATE t_account set balance=balance+? WHERE name=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setObject(1,money);
		ps.setObject(2,name);
		return ps.executeUpdate();
	}

	@Override
	public int getMoney(Connection conn,String name, BigDecimal money) throws SQLException {
		String sql="UPDATE t_account set balance=balance-? WHERE name=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setObject(1,money);
		ps.setObject(2,name);
		return ps.executeUpdate();
	}
}

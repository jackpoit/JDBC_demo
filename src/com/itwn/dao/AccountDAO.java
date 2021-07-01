package com.itwn.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Account的持久层接口
 */

public interface AccountDAO {
	/**
	 * 账号存钱(根据账户名name来增加账户余额balance)
	 * @param name 账户名
	 * @param money 存钱数
	 * @return 受影响的行数
	 */
	int saveMoney(Connection conn,String name, BigDecimal money) throws SQLException;

	/**
	 * 账户取钱(根据账户名name来减少账户余额balance)
	 * @param name 账户名
	 * @param money 取钱数
	 * @return 受影响的行数
	 */
	int getMoney(Connection conn, String name, BigDecimal money) throws SQLException;

}

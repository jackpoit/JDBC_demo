package com.itwn.service.impl;

import com.itwn.dao.AccountDAO;
import com.itwn.dao.impl.AccountDAOImpl;
import com.itwn.service.AccountService;
import com.itwn.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * AccountService的实现类
 * Service实现类的作用:内部使用DAO的CRUD完成特定的业务场景
 */
public class AccountServiceImpl implements AccountService {
	//创建AccountDAO的实现类对象
	private AccountDAO adi = new AccountDAOImpl();

	@Override
	public boolean transferMoney(String from, String to, BigDecimal money) {
		Connection conn = DBUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			int row1 = adi.getMoney(conn, from, money); //逻辑1
			if (row1 > 0) {
				int row2 = adi.saveMoney(conn, to, money);//逻辑2
				if (row2 > 0) {
					conn.commit(); //逻辑成功才能提交
					return true;
				}else {
					conn.rollback();// 防护:逻辑1ok但逻辑2失败
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			try {
				conn.rollback();  //出错 回滚(所有操作全部复位还原)
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}


		return false;
	}
}

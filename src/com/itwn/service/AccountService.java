package com.itwn.service;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Account的业务逻辑层接口
 * 目的:为Account的实际业务场景提供一套规范的API
 */
public interface AccountService {

	/**
	 * 
	 * @param from 转账人
	 * @param to   收款人
	 * @param money 转账金额
	 * @return true 成功 false 失败
	 */
	public boolean transferMoney(String from, String to, BigDecimal money);
	
	
}

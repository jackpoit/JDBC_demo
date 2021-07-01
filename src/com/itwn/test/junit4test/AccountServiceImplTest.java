package com.itwn.test.junit4test;

import com.itwn.service.AccountService;
import com.itwn.service.impl.AccountServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class AccountServiceImplTest {

	@Test
	public void transferMoney() {
		AccountService asi = new AccountServiceImpl();
		boolean result=asi.transferMoney("张三","李四",new BigDecimal("100"));
		System.out.println(result?"成功":"失败");
	}
}
package com.itheima.service;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.dao.AccountDao;
import com.itheima.dao.AccountDao4tl;
import com.itheima.utils.DatasSourceUtils;
import com.itheima.utils.JdbcUtils;

public class AccountService4tl {

	public void account(String fromuser, String touser, String money) throws Exception {
		AccountDao4tl dao = new AccountDao4tl();
		try {
			DatasSourceUtils.startTransaction();
			dao.accountOut(fromuser, money);
//			int i = 1 / 0;
			dao.accountIn(touser, money);
			DatasSourceUtils.commitAndCloseQuiety();
		} catch (Exception e) {
			e.printStackTrace();
			DatasSourceUtils.rollbackAndCloseQuiety();
			throw e;
		}
	}

}

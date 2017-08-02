package com.itheima.service;

import java.sql.Connection;

import com.itheima.dao.AccountDao;
import com.itheima.utils.JdbcUtils;

public class AccountService {

	public void account(String fromuser, String touser, String money) throws Exception {
		AccountDao dao = new AccountDao();
		Connection con = null;
		try {
			con = JdbcUtils.getConnection();
			con.setAutoCommit(false);
			dao.accountOut(con, fromuser, money);
			int i = 1 / 0;
			dao.accountIn(con, touser, money);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		} finally {
			JdbcUtils.closeConn(con);
		}

	}

}

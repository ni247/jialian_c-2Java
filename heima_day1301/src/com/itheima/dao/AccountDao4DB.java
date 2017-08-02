package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.utils.DatasSourceUtils;

public class AccountDao4DB {

	public void accountOut(String fromuser, String money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set money=money-? where name=?";
		qr.update(DatasSourceUtils.getConnection(), sql, money, fromuser);
	}

	public void accountIn(String touser, String money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set money=money+? where name=?";
		qr.update(DatasSourceUtils.getConnection(), sql, money, touser);
	}

}

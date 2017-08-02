package com.itheima.Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.utils.DatasSourceUtils;

public class UserDao {

	public int checkUsername(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select count(*) from user where username=?";
		String s = qr.query(sql, new ScalarHandler(), name).toString();
		return Integer.parseInt(s);
	}

}

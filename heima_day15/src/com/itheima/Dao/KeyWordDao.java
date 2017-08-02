package com.itheima.Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.itheima.utils.DatasSourceUtils;

public class KeyWordDao {

	public List<Object> searchKw(String key) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select kw from keyword where kw like ? limit 5";
		return qr.query(sql, new ColumnListHandler("kw"), "%" + key + "%");
	}

}

package com.itheima.Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Province;
import com.itheima.utils.DatasSourceUtils;

public class ProvinceDao {

	public List<Province> getAllProvince() throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from province";
		return qr.query(sql, new BeanListHandler<>(Province.class));
	}

}

package com.itheima.Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.City;
import com.itheima.utils.DatasSourceUtils;

public class CityDao {

	public List<City> getCity(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from city where ProvinceID=?";
		return qr.query(sql, new BeanListHandler<>(City.class), pid);
	}

}

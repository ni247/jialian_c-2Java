package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Product;
import com.itheima.utils.DatasSourceUtils;

public class ProductDao {

	public List<Product> findAll() throws SQLException {

		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from product";
		List<Product> query = qr.query(sql, new BeanListHandler<>(Product.class));
		return query;
	}

}

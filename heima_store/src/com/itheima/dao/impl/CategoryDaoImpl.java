package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.ICategoryDao;
import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import com.itheima.utils.QueryRunnerUtils;

public class CategoryDaoImpl implements ICategoryDao {

	@Override
	public List<Category> findAll() throws SQLException {
		String sql = "select * from Category  ";
		return QueryRunnerUtils.qr.query(sql, new BeanListHandler<>(Category.class));
	}

	@Override
	public List<Product> findWhere(String strWhere, String orderBy, Object... params) throws SQLException {
		String sql = "select * from Category  order by pdate limit 9";
		return QueryRunnerUtils.qr.query(sql, new BeanListHandler<>(Product.class));
	}

}

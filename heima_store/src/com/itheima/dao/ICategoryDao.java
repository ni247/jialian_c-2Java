package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.Category;
import com.itheima.domain.Product;

public interface ICategoryDao {
	public List<Category> findAll() throws SQLException;

	public List<Product> findWhere(String strWhere, String orderBy, Object... params) throws SQLException;
}

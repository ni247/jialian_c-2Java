package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductsDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

public class ProductsService {

	public List<Product> findAll(String key, String productName) throws SQLException {
		return new ProductsDao().findAll(key, productName);
	}

	public boolean addProduct(Product product) throws SQLException {
		return new ProductsDao().addProduct(product);
	}

	public Product getProductById(String id) throws SQLException {
		return new ProductsDao().getProductById(id);
	}

	public boolean editProduct(Product product) throws SQLException {
		return new ProductsDao().editProduct(product);
	}

	public boolean deleteProduct(String id) throws SQLException {
		return new ProductsDao().deleteProduct(id);
	}

	public PageBean<Product> getPageData(int currPage, int pageSize) throws SQLException {
		ProductsDao dao = new ProductsDao();
		List<Product> list = dao.getPageData(currPage, pageSize);
		int totalCount = dao.getTotalCount();
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}

}

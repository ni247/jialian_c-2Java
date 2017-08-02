package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Product;

public interface IProductDao {

	List<Product> findHot() throws Exception;

	List<Product> findNew() throws Exception;

	Product getById(String productId) throws Exception;

	List<Product> findByPages(String cid, int currPage, int pageSize) throws Exception;

	int getTotalCount(String cid) throws Exception;

}

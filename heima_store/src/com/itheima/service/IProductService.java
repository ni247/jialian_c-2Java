package com.itheima.service;

import java.util.List;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

public interface IProductService {

	List<Product> findNew() throws Exception;

	List<Product> findHot() throws Exception;

	Product getById(String productId) throws Exception;

	PageBean<Product> findByPages(String cid, int currPage,int pageSize) throws Exception;

}

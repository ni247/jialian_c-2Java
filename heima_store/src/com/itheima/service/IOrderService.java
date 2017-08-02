package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;

public interface IOrderService {

	void commitOrder(Order order) throws Exception;

	PageBean<Order> getPageOrder(User user, int currPage, int pageSize) throws Exception;

	Order getById(String oid) throws Exception;

}

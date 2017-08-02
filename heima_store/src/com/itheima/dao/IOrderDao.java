package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;

public interface IOrderDao {

	void add(Order order) throws Exception;

	void addItem(OrderItem oi) throws Exception;

	List<Order> getPageOrder(String uid, int currPage, int pageSize) throws Exception;

	List<OrderItem> getOrderItemByOId(String oid) throws Exception;

	int getOrderCountByUId(String uid) throws Exception;

	Order getById(String oid) throws Exception;

}

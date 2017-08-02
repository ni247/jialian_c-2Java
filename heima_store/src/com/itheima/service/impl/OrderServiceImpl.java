package com.itheima.service.impl;

import java.util.List;

import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import com.itheima.dao.IOrderDao;
import com.itheima.dao.IProductDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.IOrderService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.DataSourceUtils;

public class OrderServiceImpl implements IOrderService {

	@Override
	public void commitOrder(Order order) throws Exception {
		try {
			DataSourceUtils.startTransaction();
			IOrderDao dao = (IOrderDao) BeanFactory.getBean("OrderDao");
			// 添加order表
			dao.add(order);
			// 添加orderitem表
			for (OrderItem oi : order.getList()) {
				dao.addItem(oi);
			}
			DataSourceUtils.commitAndClose();
		} catch (Exception e) {
			DataSourceUtils.rollbackAndClose();
			throw e;
		}
	}

	@Override
	public PageBean<Order> getPageOrder(User user, int currPage, int pageSize) throws Exception {
		// 参数分解
		String uid = user.getUid();
		// 调用dao方法,获得order.
		IOrderDao dao = (IOrderDao) BeanFactory.getBean("OrderDao");
		/*
		 * IProductDao pdao = (IProductDao) BeanFactory.getBean("ProductDao");
		 */
		List<Order> orderList = dao.getPageOrder(uid, currPage, pageSize);
		// 遍历循环,添加orderitem,添加product
		/*
		 * for (Order order : orderList) {
		 * order.setList(dao.getOrderItemByOId(order.getOid())); for (OrderItem
		 * item : order.getList()) item.setProduct(pdao.getById(item.getPid()));
		 * }
		 */
		// 获取总数量
		int totalCount = dao.getOrderCountByUId(user.getUid());
		// 返回
		return new PageBean<>(orderList, currPage, pageSize, totalCount);
	}

	@Override
	public Order getById(String oid) throws Exception {
		// 调用dao方法,获得order.
		IOrderDao dao = (IOrderDao) BeanFactory.getBean("OrderDao");
		IProductDao pdao = (IProductDao) BeanFactory.getBean("ProductDao");
		Order order = dao.getById(oid);
		// 遍历循环,添加orderitem,添加product
		order.setList(dao.getOrderItemByOId(order.getOid()));
		for (OrderItem item : order.getList())
			item.setProduct(pdao.getById(item.getPid()));
		// 返回
		return order;
	}
}
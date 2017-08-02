package com.itheima.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.dao.IOrderDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.Product;
import com.itheima.service.IOrderService;
import com.itheima.utils.DataSourceUtils;
import com.itheima.utils.QueryRunnerUtils;

public class OrderDaoImpl implements IOrderDao {
	/**
	 * 添加一条订单
	 */
	@Override
	public void add(Order order) throws Exception {
		// 这里需要注意,使用自动事务 new QueryRunner()
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		qr.update(DataSourceUtils.getConnection(), sql, order.getOid(), order.getOrdertime(), order.getTotal(),
				order.getState(), order.getAddress(), order.getName(), order.getTelephone(), order.getUser().getUid());
	}

	/**
	 * 添加一条订单项
	 */
	@Override
	public void addItem(OrderItem oi) throws Exception {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orderitem values(?,?,?,?,?)";
		qr.update(DataSourceUtils.getConnection(), sql, oi.getItemid(), oi.getCount(), oi.getSubtotal(),
				oi.getProduct().getPid(), oi.getOrder().getOid());
	}

	@Override
	public List<Order> getPageOrder(String uid, int currPage, int pageSize) throws Exception {
		String sql = "select * from orders where uid=? limit ?,?";

		List<Order> orderList = QueryRunnerUtils.qr.query(sql, new BeanListHandler<>(Order.class), uid,
				(currPage - 1) * pageSize, pageSize);
		sql = "select * from orderitem oi,product p where oi.pid=p.pid and oi.oid=?";
		Product pro;
		OrderItem item;
		for (Order order : orderList) {
			List<Map<String, Object>> query = QueryRunnerUtils.qr.query(sql, new MapListHandler(), order.getOid());
			pro = new Product();
			item = new OrderItem();
			for (Map<String, Object> m : query) {
				BeanUtils.populate(pro, m);
				BeanUtils.populate(item, m);
				item.setProduct(pro);
				order.getList().add(item);
			}
		}
		return orderList;
	}

	@Override
	public List<OrderItem> getOrderItemByOId(String oid) throws Exception {
		String sql = "select * from orderitem where oid=?";
		return QueryRunnerUtils.qr.query(sql, new BeanListHandler<>(OrderItem.class), oid);
	}

	@Override
	public int getOrderCountByUId(String uid) throws Exception {
		String sql = "select count(*) from orders where uid=?";
		return Integer.parseInt(QueryRunnerUtils.qr.query(sql, new ScalarHandler(1), uid).toString());
	}

	@Override
	public Order getById(String oid) throws Exception {
		String sql = "select * from orders where oid=?";
		return QueryRunnerUtils.qr.query(sql, new BeanHandler<>(Order.class), oid);
	}

}

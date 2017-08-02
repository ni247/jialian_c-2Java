package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.dao.IProductDao;
import com.itheima.domain.Product;
import com.itheima.utils.QueryRunnerUtils;

public class ProductDaoImpl implements IProductDao {
	public List<Product> findHot() throws SQLException {
		String sql = "select * from product where is_hot=1 limit 9 ";
		return QueryRunnerUtils.qr.query(sql, new BeanListHandler<>(Product.class));
	}

	public List<Product> findNew() throws SQLException {
		String sql = "select * from product  order by pdate limit 9";
		return QueryRunnerUtils.qr.query(sql, new BeanListHandler<>(Product.class));
	}

	@Override
	public Product getById(String productId) throws Exception {
		String sql = "select * from product where pid=?";
		return QueryRunnerUtils.qr.query(sql, new BeanHandler<>(Product.class), productId);
	}

	@Override
	public List<Product> findByPages(String cid, int currPage, int pageSize) throws Exception {
		String sql = "select * from product where cid =? limit ?,?";
		return QueryRunnerUtils.qr.query(sql, new BeanListHandler<>(Product.class), cid, (currPage - 1) * pageSize,
				pageSize);
	}

	@Override
	public int getTotalCount(String cid) throws Exception {
		String sql = "select count(*) from product where cid =?";
		return Integer.parseInt(QueryRunnerUtils.qr.query(sql, new ScalarHandler(1), cid).toString());
	}
}

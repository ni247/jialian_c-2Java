package com.itheima.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import utils.DatasSourceUtils;

public class ProductsDao {

	public List<Product> findAll(String key, String productName) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from product where 1=1";
		ArrayList<String> list = new ArrayList<>();
		if (key != null && key.length() > 0) {
			sql += " and pdesc like ?";
			list.add("%" + key + "%");
		}
		if (productName != null && productName.length() > 0) {
			sql += " and pname like ?";
			list.add("%" + productName + "%");
		}
		if (list.size() > 0)
			return qr.query(sql, new BeanListHandler<>(Product.class), list.toArray());
		else
			return qr.query(sql, new BeanListHandler<>(Product.class));
	}

	public boolean addProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		int query = qr.update(sql, product.getPid(), product.getPname(), product.getMarket_price(),
				product.getShop_price(), product.getPimage(), product.getPdate(), product.getPdesc());
		return query == 1 ? true : false;
	}

	public Product getProductById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product query = qr.query(sql, new BeanHandler<>(Product.class), id);
		return query;
	}

	public boolean editProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "update  product set pname=?, market_price=?,shop_price=?,pimage=?,pdate=?,pdesc=? where pid=?";
		int query = qr.update(sql, product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPimage(), product.getPdate(), product.getPdesc(), product.getPid());
		return query == 1 ? true : false;
	}

	public boolean deleteProduct(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "delete from  product where pid=?";
		int query = qr.update(sql, id);
		return query == 1 ? true : false;
	}

	public List<Product> getPageData(int currPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		int start = (currPage - 1) * pageSize;
		String sql = "select * from product limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Product.class), start, pageSize);
	}

	public int getTotalCount() throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		return (Integer.parseInt(qr.query(sql, new ScalarHandler()).toString()));
	}
}

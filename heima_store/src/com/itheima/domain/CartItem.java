package com.itheima.domain;

import java.io.Serializable;

/**
 * 购物车项
 * @author Administrator
 *
 */
public class CartItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product; // 商品对象

	public CartItem(Product product, Integer count) {
		super();
		this.product = product;
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return product.getShop_price() * this.count;
	}

	private Integer count; // 购买数量
	private Double subtotal; // 小计
}

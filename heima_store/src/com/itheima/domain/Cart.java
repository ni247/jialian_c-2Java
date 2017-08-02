package com.itheima.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 存放购物车的集合,key:商品id.cartitem:购物车项.
	private Map<String, CartItem> map = new LinkedHashMap<>();

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	private Double total = 0.0;

	// 添加到购物车
	public void add2Cart(CartItem item) {
		// 判断购物车是否有产品
		Product product = item.getProduct();
		String pid = product.getPid();
		if (map.containsKey(pid))
			map.get(pid).setCount(map.get(pid).getCount() + item.getCount());
		else
			map.put(pid, item);
		// 更新总金额
		total += item.getSubtotal();
	}

	// 从购物车删除
	public void removeFromCart(String id) {
		if (map.containsKey(id)) {
			CartItem item = map.remove(id);
			total -= item.getSubtotal();
		}
	}

	// 清空购物车
	public void clearCart() {
		map.clear();
		total = 0.0;
	}

	public Collection<CartItem> getItems() {
		return map.values();
	}
}

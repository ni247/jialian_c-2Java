package com.itheima.demo4;

/**
 * 演示的构造方法的注入的方式
 * @author Administrator
 *
 */
public class Car1 {
	public Car1(String cname, String price) {
		super();
		this.cname = cname;
		this.price = price;
	}

	private String cname;
	private String price;

	@Override
	public String toString() {
		return "Car1 [cname=" + cname + ", price=" + price + "]";
	}
}

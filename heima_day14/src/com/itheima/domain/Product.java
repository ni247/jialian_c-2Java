package com.itheima.domain;

import java.util.Date;

public class Product {
	/*
	 * `pid` varchar (96), `pname` varchar (150), `market_price` double ,
	 * `shop_price` double , `pimage` varchar (600), `pdate` date , `pdesc`
	 * varchar (765)
	 */

	private String pid;
	private String pname;
	private double market_price;
	private double shop_price;
	private String pimage;
	private String pdate;
	private String pdesc;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Product() {
		super();
	}

	public double getMarket_price() {
		return market_price;
	}

	public Product(String pid, String pname, double market_price, double shop_price, String pimage, String pdate,
			String pdesc) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.pimage = pimage;
		this.pdate = pdate;
		this.pdesc = pdesc;
	}

	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}

	public double getShop_price() {
		return shop_price;
	}

	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

}

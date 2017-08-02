package com.itheima.domain;

public class Province {
	private int provinceID;
	private String name;

	public int getProvinceID() {
		return provinceID;
	}

	public Province() {
		super();
	}

	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province(int provinceID, String name) {
		super();
		this.provinceID = provinceID;
		this.name = name;
	}
}

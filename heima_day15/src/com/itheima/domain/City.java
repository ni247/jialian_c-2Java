package com.itheima.domain;

public class City {
	private int cityID;
	private int provinceID;

	public City() {
		super();
	}

	private String name;

	public City(int cityID, int provinceID, String name) {
		super();
		this.cityID = cityID;
		this.provinceID = provinceID;
		this.name = name;
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public int getProvinceID() {
		return provinceID;
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

}

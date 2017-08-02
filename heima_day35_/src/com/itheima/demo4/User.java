package com.itheima.demo4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * 演示集合注入的方式
 */
public class User {
	private String[] atts;
	private Car2 car2;
	private HashMap<String, String> map;
	private Properties pro;

	public void setPro(Properties pro) {
		this.pro = pro;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public void setCar2(Car2 car2) {
		this.car2 = car2;
	}

	public void setAtts(String[] atts) {
		this.atts = atts;
	}

	@Override
	public String toString() {
		return "User [atts=" + Arrays.toString(atts) + ", car2=" + car2 + ", map=" + map + ", pro=" + pro + "]";
	}

}

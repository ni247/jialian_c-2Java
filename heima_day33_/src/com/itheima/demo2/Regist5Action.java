package com.itheima.demo2;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 属性驱动,吧数据封装到list集合中
 * @author Administrator
 *
 */
public class Regist5Action extends ActionSupport {
	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

	private Map<String, User> map;

	@Override
	public String execute() throws Exception {
		System.out.println(map);
		return NONE;
	}
}

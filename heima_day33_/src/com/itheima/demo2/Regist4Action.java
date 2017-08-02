package com.itheima.demo2;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 属性驱动,吧数据封装到list集合中
 * @author Administrator
 *
 */
public class Regist4Action extends ActionSupport {
	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		for (User user : list) {
			System.out.println(user);
		}
		return NONE;
	}
}

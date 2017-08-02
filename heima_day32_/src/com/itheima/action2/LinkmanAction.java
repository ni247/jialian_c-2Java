package com.itheima.action2;

import com.opensymphony.xwork2.ActionSupport;

public class LinkmanAction extends ActionSupport {
	public String save() {
		System.out.println("保存了联系人");
		return NONE;
	}

	public String delete() {
		System.out.println("删除联系人");
		return NONE;
	}
}

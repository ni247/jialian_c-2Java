package com.itheima.action2;

import org.apache.commons.lang3.ObjectUtils.Null;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	public String save() {
		System.out.println("保存了客户");
		return NONE;
	}

	public String delete() {
		System.out.println("删除客户");
		return NONE;
	}
}

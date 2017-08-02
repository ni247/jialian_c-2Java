package com.itheima.action1;

import com.opensymphony.xwork2.Action;

public class Demo2Action implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("demo2action进行中");
		return SUCCESS;
	}


}

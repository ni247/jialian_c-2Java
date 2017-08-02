package com.itheima.demo1;

import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 完全解耦合方式
 * @author Administrator
 *
 */
public class Demo4Action extends ActionSupport {

	public String execute() {
		System.out.println("默认方法运行");
		return SUCCESS;
	}
}

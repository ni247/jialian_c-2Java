package com.itheima.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person() {
		super();
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	// 绑定
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("person对象绑定到了session中");
	}

	@Override
	// 解绑
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("person对象从session中移除了");
	}
}

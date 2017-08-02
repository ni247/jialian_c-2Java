package com.itheima.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Person2 implements HttpSessionActivationListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4826434319583420620L;
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person2() {
		super();
	}

	public Person2(int id, String name) {
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
	// 钝化
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("person对象写入磁盘:钝化");
	}

	@Override
	// 活化
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("person对象活化,从磁盘出来了");
	}
}

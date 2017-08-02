package com.itheima.domain;

public class Person {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		System.out.println("我是带参构造器");
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person() {
		super();
		System.out.println("我是空参构造器");
	}

	public void eat() {
		System.out.println("会吃");
	}
}

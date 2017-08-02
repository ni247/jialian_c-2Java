package com.itheima.domain;

public class HelloMyServlet {
	public HelloMyServlet(int a) {
		System.out.println(a);
	}

	public HelloMyServlet() {

	}

	public void add() {
		System.out.println("空参add方法");
	}

	public void add(int i, int j) {
		System.out.println("带有两个参数" + i + j);
	}

	public int add(int i) {
		return i + 10;
	}
}

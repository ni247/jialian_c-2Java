package com.itheima.domain;

import com.itheima.myEnum.Color;

public class User {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}

	@SuppressWarnings("all")
	private int s;

	@Deprecated
	public static void add() {

	}

	public static void main(String[] args) {
		add();
	}
}

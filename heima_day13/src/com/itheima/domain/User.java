package com.itheima.domain;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class User {
	private String username;
	private String password;

	public String getUsername() {
		return username;
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

	public void eat() {
		System.out.println("真能吃");
	}

	private void eat(String name) {
		System.out.println(name + "这能吃");
	}

	public int sleep() {
		System.out.println("真能吃");
		return 1;
	}

	private int sleep1(String name) {
		System.out.println(name + "真能吃");
		return 1;
	}

}

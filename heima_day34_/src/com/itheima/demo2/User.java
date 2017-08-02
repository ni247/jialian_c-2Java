package com.itheima.demo2;

public class User {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", pwd=" + pwd + "]";
	}

	public User() {
		super();
	}

	public String getPwd() {
		return pwd;
	}

	public User(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	private String pwd;
}

package com.itheima.domain;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String sex;
	private String birthday;
	private String hobby;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", name="
				+ name + ", sex=" + sex + ", birthday=" + birthday + ", hobby=" + hobby + "]";
	}

	public User(int id, String username, String password, String email, String name, String sex, String birthday,
			String hobby) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.hobby = hobby;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public void setId(int id) {
		this.id = id;
	}

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
}

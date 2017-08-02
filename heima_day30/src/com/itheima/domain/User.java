package com.itheima.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统用户
 * @author Administrator
 *
 */
public class User implements Serializable {
	private Long uid;
	private String username;
	private String password;
	// 绑定都是集合
	private Set<Role> roles = new HashSet();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
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

package com.itheima.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统角色
 * @author Administrator
 *
 */
public class Role implements Serializable {
	private Long rid;
	private String rname;
	private Set<User> users = new HashSet<>();

	public Long getRid() {
		return rid;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}
}

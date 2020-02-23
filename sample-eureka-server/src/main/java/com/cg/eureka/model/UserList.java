package com.cg.eureka.model;

import java.util.List;

public class UserList {

	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserList() {
		super();

	}

	public UserList(List<User> userList) {
		super();
		this.userList = userList;
	}

}

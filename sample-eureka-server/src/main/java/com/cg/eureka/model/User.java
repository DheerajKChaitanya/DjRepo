package com.cg.eureka.model;

public class User {

	private Integer id;
	private String userName;
	private String company;
	private String city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User(Integer id, String userName, String company, String city) {
		super();
		this.id = id;
		this.userName = userName;
		this.company = company;
		this.city = city;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}

package com.dj.app.redis.springredis.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private Integer id;
	private String name;
	private Double salary;
	private String emailId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, Double salary, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.emailId = emailId;
	}
	
	

}

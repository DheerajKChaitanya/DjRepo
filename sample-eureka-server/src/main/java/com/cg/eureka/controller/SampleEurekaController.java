package com.cg.eureka.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eureka.model.User;
import com.cg.eureka.model.UserList;

@RestController
public class SampleEurekaController {

	UserList userList = new UserList();

	@PostConstruct
	public void initilize() {

		List<User> users = new ArrayList<>();
		users.add(new User(1, "Dheeraj", "Alphabet", "Hyderabad"));
		users.add(new User(2, "Chaitanya", "Google", "Mumbai"));
		users.add(new User(3, "Kanchibhotla", "Microsoft", "Pune"));
		users.add(new User(4, "Mahesh", "Apple", "Banglore"));
		userList.setUserList(users);

	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserList getUserDetails() {

		return userList;
	}

}

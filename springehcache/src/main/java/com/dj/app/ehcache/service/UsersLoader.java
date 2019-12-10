package com.dj.app.ehcache.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dj.app.ehcache.model.Users;
import com.dj.app.ehcache.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UsersLoader {

	@Autowired
	UsersRepository usersRepository;

	@PostConstruct
	public void addUsers() {
		List<Users> userList = new ArrayList<>();
		userList.add(new Users(1, "Dheeraj", 8889997779L, 50000D));
		userList.add(new Users(2, "Chaitanya", 33344556L, 60000D));
		userList.add(new Users(3, "Mahesh", 2223334445L, 10000D));
		userList.add(new Users(4, "Harshith", 1112223334L, 70000D));
		log.info("Added users--" + userList.size());
		usersRepository.saveAll(userList);
	}

}

package com.dj.app.ehcache.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.dj.app.ehcache.model.Users;
import com.dj.app.ehcache.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UsersCache {

	@Autowired
	UsersRepository usersRepository;

	@Cacheable(value = "usersCache", key = "#name")
	public Users getUser(String name) {
		log.info("Retrieving from database for user--" + name);

		return usersRepository.findByUserName(name);
	}

}

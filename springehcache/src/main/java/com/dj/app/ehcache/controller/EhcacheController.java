package com.dj.app.ehcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dj.app.ehcache.model.Users;
import com.dj.app.ehcache.service.UsersCache;

@RestController
@RequestMapping("/springboot/ehcache")
public class EhcacheController {

	@Autowired
	UsersCache usersCache;

	@GetMapping("/users/{name}")
	public Users getUser(@PathVariable String name) {
		
		return usersCache.getUser(name);
	}

}

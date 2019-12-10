package com.dj.app.redis.springredis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dj.app.redis.springredis.model.User;
import com.dj.app.redis.springredis.repository.UserRepository;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {

		userRepository.save(user);

		return getUserDetailsById(user.getId());
	}

	@GetMapping("/user/{id}")
	public User getUserDetailsById(@PathVariable("id") Integer id) {

		return userRepository.findById(id);
	}

	@GetMapping("/users")
	public Map<Integer, User> getUserDetails() {

		return userRepository.findAll();
	}

	@PutMapping("/user")
	public User updateUserDetails(@RequestBody User user) {

		userRepository.update(user);

		return getUserDetailsById(user.getId());
	}

	@DeleteMapping("/user/{id}")
	public void deleteUserDetails(@PathVariable("id") Integer id) {

		userRepository.delete(id);
	}

}

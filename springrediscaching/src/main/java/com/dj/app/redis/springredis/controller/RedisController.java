package com.dj.app.redis.springredis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

import redis.clients.jedis.Jedis;

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
	@Cacheable(key = "#id", value = "users",sync=true)
	public User getUserDetailsById(@PathVariable("id") Integer id) {
		System.out.println("getUserDetailsById--"+id);
		User usr=userRepository.findById(id);
		return usr;
	}

	@GetMapping("/users")
	public Map<Integer, User> getUserDetails() {

		return userRepository.findAll();
	}

	@PutMapping("/user")
	@CachePut( value = "users",key = "#user.id", unless="#user==null")
	public String updateUserDetails(@RequestBody User user) {

		userRepository.update(user);

		return user.getName()+" Details updated";
	}

	@DeleteMapping("/user/{id}")
	@CacheEvict(key = "#id", value = "users")
	public void deleteUserDetails(@PathVariable("id") Integer id) {

		userRepository.delete(id);
	}

	@GetMapping("/clearCahche")
	public void clearCache() {
		
		Jedis jedis = new Jedis("localhost");
		jedis.connect();
		jedis.flushAll();
		jedis.disconnect();

	}

}

package com.dj.app.redis.springredis.repository;

import java.util.Map;

import com.dj.app.redis.springredis.model.User;


public interface UserRepository {

	void save(User user);

	User findById(Integer id);

	Map<Integer, User> findAll();

	void update(User user);

	void delete(Integer id);

}

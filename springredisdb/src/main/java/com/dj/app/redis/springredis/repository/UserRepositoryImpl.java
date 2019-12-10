package com.dj.app.redis.springredis.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.dj.app.redis.springredis.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private RedisTemplate<Integer, User> redisTemplate;
	private HashOperations<Integer, Integer, User> hashOperations;

	public UserRepositoryImpl(RedisTemplate<Integer, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		hashOperations.put(123, user.getId(), user);
	}

	@Override
	public User findById(Integer id) {

		return hashOperations.get(123, id);
	}

	@Override
	public Map<Integer, User> findAll() {

		return hashOperations.entries(123);
	}

	@Override
	public void update(User user) {
		save(user);
	}

	@Override
	public void delete(Integer id) {

		hashOperations.delete(123, id);

	}

}

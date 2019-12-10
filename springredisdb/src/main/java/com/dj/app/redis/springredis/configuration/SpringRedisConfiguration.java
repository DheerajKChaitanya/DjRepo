package com.dj.app.redis.springredis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.dj.app.redis.springredis.model.User;

@Configuration
public class SpringRedisConfiguration {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<Integer, User> redisTemplate() {
		RedisTemplate<Integer, User> redisTemplate = new RedisTemplate<Integer, User>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

}

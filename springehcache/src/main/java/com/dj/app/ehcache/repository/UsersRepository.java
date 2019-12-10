package com.dj.app.ehcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dj.app.ehcache.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByUserName(String name);
	Users findByPhoneNumber(Long phoneNumber);

}

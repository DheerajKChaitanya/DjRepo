package com.example.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.elasticsearch.jparepo.CustomerJpaRepository;
import com.example.elasticsearch.model.Customer;
import com.example.elasticsearch.repository.CustomerRepo;

@RestController
public class JpaResource {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CustomerJpaRepository customerJpaRepository;

	@GetMapping("/savetodatabase")
	public Iterable<Customer> getAllCustomerDetails() {

		Iterable<Customer> list = customerRepo.findAll();

		return customerJpaRepository.saveAll(list);
	}

}

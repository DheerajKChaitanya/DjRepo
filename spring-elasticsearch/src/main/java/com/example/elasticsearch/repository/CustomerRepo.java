package com.example.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.elasticsearch.model.Customer;

public interface CustomerRepo extends ElasticsearchRepository<Customer, String>{
	
	List<Customer> findByFirstName(String firstName);
	List<Customer> findByLastName(String LastName);
	List<Customer> findByAge(int age);

}

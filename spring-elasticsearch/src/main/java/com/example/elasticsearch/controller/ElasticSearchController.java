package com.example.elasticsearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.elasticsearch.model.Customer;
import com.example.elasticsearch.repository.CustomerRepo;

@RestController
public class ElasticSearchController {

	@Autowired
	private CustomerRepo customerRepo;

	@PostMapping("/customer")
	public String addCustomerDetails(@RequestBody Customer customer) {

		Customer custDetails = new Customer();

		if (customer != null) {
			custDetails = customerRepo.save(customer);
		}

		return custDetails.getFirstName() + " details added succesfully";
	}

	@GetMapping("/customers")
	public Iterable<Customer> getAllCustomerDetails() {

		return customerRepo.findAll();
	}

	@GetMapping("/customer/{id}")
	public Customer getCustomerDetailsById(@PathVariable(name = "id") String id) {
		Customer custDetails = new Customer();
		Optional<Customer> optionalDetails = customerRepo.findById(id);
		custDetails = optionalDetails.get();
		return custDetails;
	}

	@GetMapping("/customer/firstname/{firstname}")
	public List<Customer> getCustomerDetailsByFirstName(@PathVariable(name = "firstname") String name) {

		List<Customer> custDetails = customerRepo.findByFirstName(name);

		return custDetails;
	}

	@GetMapping("/customer/lastname/{lastname}")
	public List<Customer> getCustomerDetailsByLastName(@PathVariable(name = "lastname") String name) {

		List<Customer> custDetails = customerRepo.findByLastName(name);

		return custDetails;
	}

	@GetMapping("/customer/age/{age}")
	public List<Customer> getCustomerDetailsByLastName(@PathVariable(name = "age") int age) {

		List<Customer> custDetails = customerRepo.findByAge(age);

		return custDetails;
	}

	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable(name = "id") String id) {

		customerRepo.deleteById(id);

	}

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.EmployeeList;

@RestController
public class RestTemplateController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/message")
	public String getMessage() {

		EmployeeList employee = restTemplate.getForObject("http://localhost:8081/Employees", EmployeeList.class);

		if (employee != null) {
			return "Success";
		} else {
			return "Fail";
		}
	}

}

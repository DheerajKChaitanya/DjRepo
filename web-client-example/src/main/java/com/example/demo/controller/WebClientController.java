package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.EmployeeList;

@RestController
public class WebClientController {

	@Autowired
	WebClient.Builder WebClientBuilder;

	@GetMapping("/message")
	public String getMessage() {

		EmployeeList employee = WebClientBuilder.build().get().uri("http://localhost:8081/Employees").retrieve()
				.bodyToMono(EmployeeList.class).block();

		if (employee != null) {
			return "Success";
		} else {
			return "Fail";
		}
	}

}

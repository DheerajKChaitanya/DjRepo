package com.cg.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaClientTwoController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/eureka-client-two")
	public String getMessage() {

		String url = "http://EUREKA-CLIENT-ONE/message";
		restTemplate.getForObject(url, String.class);

		return restTemplate.getForObject(url, String.class);
	}

}

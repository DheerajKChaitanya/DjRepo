package com.cg.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientOneController {

	@GetMapping("/message")
	public String getMessage() {
		return "Hello from Eureka Client One";
	}

}

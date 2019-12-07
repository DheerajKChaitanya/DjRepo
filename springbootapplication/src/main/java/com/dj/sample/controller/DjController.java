package com.dj.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springboot")
public class DjController {

	@GetMapping("/Message")
	public String getMessage() {
		return "Welcome to Spring Boot Application";
	}

}

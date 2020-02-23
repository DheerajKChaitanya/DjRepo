package com.cg.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SampleEureka {

	public static void main(String[] args) {
		SpringApplication.run(SampleEureka.class, args);
	}
}

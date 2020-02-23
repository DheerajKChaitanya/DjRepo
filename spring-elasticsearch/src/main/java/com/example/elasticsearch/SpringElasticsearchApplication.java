package com.example.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.elasticsearch.jparepo")
public class SpringElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticsearchApplication.class, args);
	}

}

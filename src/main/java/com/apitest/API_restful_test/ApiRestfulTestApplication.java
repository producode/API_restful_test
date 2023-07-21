package com.apitest.API_restful_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.apitest.API_restful_test.Entity")
@EnableJpaRepositories("com.apitest.API_restful_test.*")
@ComponentScan(basePackages = { "com.apitest.API_restful_test.*" })
public class ApiRestfulTestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestfulTestApplication.class, args);
	}

}
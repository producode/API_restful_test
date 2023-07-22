package com.apitest.API_restful_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.apitest.API_restful_test.*")
@ComponentScan(basePackages = { "com.apitest.API_restful_test.*" })
@EntityScan("com.apitest.API_restful_test.entity")
public class ApiRestfulTestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestfulTestApplication.class, args);
	}

}
package com.marsmob.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
/**
 * security.basic.enabled = false 已经过时
 * 改为@EnableAutoConfiguration(exclude= {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
 */
@EnableAutoConfiguration(exclude= {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("hello")
	public String hello()
	{
		return "hello springboot-security";
	}
}

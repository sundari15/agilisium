package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.web")
@SpringBootApplication
public class AgilisiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgilisiumApplication.class, args);
	}

}

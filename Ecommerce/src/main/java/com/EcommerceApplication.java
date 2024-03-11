package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class EcommerceApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}

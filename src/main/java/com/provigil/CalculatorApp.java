package com.provigil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class CalculatorApp {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApp.class, args);
	}
	
}

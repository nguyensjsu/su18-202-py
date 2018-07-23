package com.sjsu.payments;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sjsu.payments"})
@EnableDynamoDBRepositories({"com.sjsu.payments"})
public class StarbucksPaymentsApplication {


	public static void main(String[] args) {
		SpringApplication.run(StarbucksPaymentsApplication.class, args);
	}
	
}

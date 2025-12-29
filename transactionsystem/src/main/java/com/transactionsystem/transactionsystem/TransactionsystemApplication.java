package com.transactionsystem.transactionsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TransactionsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsystemApplication.class, args);
	}

}

package com.revature.monster_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Implies: @Configuration, @AutoConfiguration, @ComponentScan
public class MonsterLabDriver {

	public static void main(String[] args) {
		SpringApplication.run(MonsterLabDriver.class, args);
	}
}

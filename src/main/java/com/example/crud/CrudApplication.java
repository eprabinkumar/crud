package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//SpringBootApplication is combination of @Configuration, @EnableAutoConfiguration and @ComponentScan
//@Configuration is a source of bean definitions
//@EnableAutoConfiguration tells spring to automatically configure your application based on pom.xml
//@ComponentScan tells spring scan other components and bootstrap other components defined in the current packages.

@EnableJpaAuditing  //Enable Jpa auditing i.e tracking and logging events related to persistence entities
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}

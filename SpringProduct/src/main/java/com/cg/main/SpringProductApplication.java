package com.cg.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories ("com.cg")
@ComponentScan ("com.cg")
@EnableAutoConfiguration
public class SpringProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductApplication.class, args);
	}
}

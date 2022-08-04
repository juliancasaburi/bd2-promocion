package com.bbdd2promocion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(excludeFilters={ @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=JobLauncherApplicationRunner.class)})
@EnableJpaRepositories(basePackages = "com.bbdd2promocion.repository.jpa")
@EnableMongoRepositories(basePackages = "com.bbdd2promocion.repository.mongo")
public class BBDD2PromocionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BBDD2PromocionApplication.class, args);
	}

}

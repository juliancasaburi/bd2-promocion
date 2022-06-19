package com.bbdd2promocion;

import com.bbdd2promocion.seed.mongodb.InsertionJobConfiguration;
import com.bbdd2promocion.seed.mongodb.MongoDBConfiguration;
import com.bbdd2promocion.seed.mongodb.TestModelInsertionJobConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(excludeFilters={ @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=JobLauncherApplicationRunner.class)})
@EnableJpaRepositories(basePackages = "com.bbdd2promocion.repository.jpa")
@EnableMongoRepositories(basePackages = "com.bbdd2promocion.repository.mongo")
public class BBDD2PromocionApplication {

	public static void main(String[] args) throws Exception {
		Class<?>[] configurationClasses = { InsertionJobConfiguration.class, TestModelInsertionJobConfiguration.class, MongoDBConfiguration.class };
		ApplicationContext context = new AnnotationConfigApplicationContext(configurationClasses);

		SpringApplication.run(BBDD2PromocionApplication.class, args);

		// run the insertion jobs
		/*
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job testModelinsertionJob = context.getBean("testModelInsertionJob", Job.class);
		jobLauncher.run(testModelinsertionJob, new JobParameters());

		Job insertionJob = context.getBean("insertionJob", Job.class);
		jobLauncher.run(insertionJob, new JobParameters());
		*/
	}

}

package com.bbdd2promocion;

import com.bbdd2promocion.seed.mongodb.InsertionJobConfiguration;
import com.bbdd2promocion.seed.mongodb.MongoDBConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BBDD2PromocionApplication {

	public static void main(String[] args) throws Exception {
		Class<?>[] configurationClasses = { InsertionJobConfiguration.class, MongoDBConfiguration.class };
		ApplicationContext context = new AnnotationConfigApplicationContext(configurationClasses);
		SpringApplication.run(BBDD2PromocionApplication.class, args);
		// run the insertion job
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job insertionJob = context.getBean("insertionJob", Job.class);
		jobLauncher.run(insertionJob, new JobParameters());
	}

}

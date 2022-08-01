/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.bbdd2promocion.service.impl;

import com.bbdd2promocion.config.HibernateConfiguration;
import com.bbdd2promocion.config.MongoDBConfiguration;
import com.bbdd2promocion.seed.mongodb.AccidentMongoInsertionJobConfiguration;
import com.bbdd2promocion.seed.mongodb.TestModelMongoInsertionJobConfiguration;
import com.bbdd2promocion.seed.postgresql.AccidentPostgresInsertionJobConfiguration;
import com.bbdd2promocion.seed.postgresql.TestModelPostgresInsertionJobConfiguration;
import com.bbdd2promocion.service.ISeedingService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SeedingServiceImpl implements ISeedingService {

    private void runJob(Class<?>[] configurationClasses, String jobName) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        ApplicationContext context = new AnnotationConfigApplicationContext(configurationClasses);
        Job job = context.getBean(jobName, Job.class);
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }

    @Override
    public void seedTestModelMongoDB() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        Class<?>[] configurationClasses = { TestModelMongoInsertionJobConfiguration.class, MongoDBConfiguration.class };
        this.runJob(configurationClasses, "testModelInsertionJob");
    }

    @Override
    public void seedTestModelPostgreSQL() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException {

        Class<?>[] configurationClasses = { TestModelPostgresInsertionJobConfiguration.class, HibernateConfiguration.class };
        this.runJob(configurationClasses, "testModelPostgresInsertionJob");
    }

    @Override
    public void seedAccidentMongoDB() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException {

        Class<?>[] configurationClasses = { AccidentMongoInsertionJobConfiguration.class, MongoDBConfiguration.class };
        this.runJob(configurationClasses, "accidentMongoInsertionJob");
    }

    @Override
    public void seedAccidentPostgreSQL() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException {

        Class<?>[] configurationClasses = { AccidentPostgresInsertionJobConfiguration.class, HibernateConfiguration.class };
        this.runJob(configurationClasses, "accidentPostgresInsertionJob");
    }

}

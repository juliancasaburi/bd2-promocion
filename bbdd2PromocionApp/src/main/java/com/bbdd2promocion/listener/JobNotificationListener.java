package com.bbdd2promocion.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class JobNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobNotificationListener.class);

  @Override
  public void beforeJob(JobExecution jobExecution) {
    log.info("JOB: " + jobExecution.getJobId() + " STARTED");
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB: " + jobExecution.getJobId() + " FINISHED!");
    }
  }
}

package com.bbdd2promocion.seed.mongodb;

import com.bbdd2promocion.dto.AccidentDTO;
import com.bbdd2promocion.listener.JobNotificationListener;
import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.seed.AccidentItemProcessor;
import com.bbdd2promocion.seed.CommonAccidentSeedingJobConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableBatchProcessing
@Import(CommonAccidentSeedingJobConfiguration.class)
public class AccidentMongoInsertionJobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;

  private final StepBuilderFactory stepBuilderFactory;

  public AccidentMongoInsertionJobConfiguration(
      JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
    this.jobBuilderFactory = jobBuilderFactory;
    this.stepBuilderFactory = stepBuilderFactory;
  }

  @Bean
  public MongoItemWriter<Accident> mongoItemWriter(MongoTemplate mongoTemplate) {
    return new MongoItemWriterBuilder<Accident>()
        .template(mongoTemplate)
        .collection("Accidents")
        .build();
  }

  @Bean
  public Step step(
      @Qualifier("asyncTaskExecutorMongo") TaskExecutor taskExecutor,
      FlatFileItemReader<AccidentDTO> flatFileIteamReader,
      MongoItemWriter<Accident> mongoItemWriter,
      AccidentItemProcessor processor) {
    return this.stepBuilderFactory
        .get("step")
        .<AccidentDTO, Accident>chunk(10000)
        .reader(flatFileIteamReader)
        .processor(processor)
        .writer(mongoItemWriter)
        .taskExecutor(taskExecutor)
        .build();
  }

  @Bean(name = "asyncTaskExecutorMongo")
  public TaskExecutor taskExecutor() {
    return new SimpleAsyncTaskExecutor("spring_batch_accident_mongo");
  }

  @Bean
  public Job accidentMongoInsertionJob(Step step) {
    return this.jobBuilderFactory
        .get("accidentMongoInsertionJob")
        .listener(new JobNotificationListener())
        .start(step)
        .build();
  }
}

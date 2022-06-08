package com.bbdd2promocion.seed.mongodb;

import com.bbdd2promocion.listener.JobNotificationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.core.io.ClassPathResource;

import com.bbdd2promocion.model.mongodb.TestModel;

@EnableBatchProcessing
public class InsertionJobConfiguration {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    public InsertionJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public FlatFileItemReader<TestModel> reader() {
        return new FlatFileItemReaderBuilder<TestModel>().name("testModelItemReader")
                .resource(new ClassPathResource("testModel.csv")).delimited()
                .names(new String[] {"Title", "Description"})
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<TestModel>() {
                    {
                        setTargetType(TestModel.class);
                    }
                }).build();
    }

    @Bean
    public MongoItemWriter<TestModel> mongoItemWriter(MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<TestModel>().template(mongoTemplate).collection("TestModel").build();
    }

    @Bean
    public Step step(FlatFileItemReader<TestModel> flatFileIteamReader, MongoItemWriter<TestModel> mongoItemWriter) {
        return this.stepBuilderFactory.get("step").<TestModel, TestModel>chunk(2).reader(flatFileIteamReader)
                .writer(mongoItemWriter).build();
    }

    @Bean
    public Job insertionJob(Step step) {
        return this.jobBuilderFactory.get("insertionJob").listener(new JobNotificationListener()).start(step).build();
    }

}

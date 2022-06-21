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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.core.io.ClassPathResource;

import com.bbdd2promocion.model.TestModel;

@EnableBatchProcessing
public class TestModelInsertionJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    public TestModelInsertionJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean(name="testModelMongoDBReader")
    public FlatFileItemReader<TestModel> testModelReader() {
        return new FlatFileItemReaderBuilder<TestModel>().name("testModelItemReader")
                .resource(new ClassPathResource("testModel.csv")).delimited()
                .names(new String[] {"csvId", "title", "description"})
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<TestModel>() {
                    {
                        setTargetType(TestModel.class);
                        setDistanceLimit(1);
                    }
                }).build();
    }

    @Bean
    public MongoItemWriter<TestModel> testModelMongoItemWriter(MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<TestModel>().template(mongoTemplate).collection("TestModel").build();
    }

    @Bean(name="testModelStep")
    public Step testModelStep(@Qualifier("testModelMongoDBReader") FlatFileItemReader<TestModel> testModelFlatFileIteamReader, MongoItemWriter<TestModel> testModelMongoItemWriter) {
        return this.stepBuilderFactory.get("testModelStep").<TestModel, TestModel>chunk(2).reader(testModelFlatFileIteamReader)
                .writer(testModelMongoItemWriter).build();
    }

    @Bean
    public Job testModelInsertionJob(@Qualifier("testModelStep") Step step) {
        return this.jobBuilderFactory.get("testModelInsertionJob").listener(new JobNotificationListener()).start(step).build();
    }

}

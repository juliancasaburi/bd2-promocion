package com.bbdd2promocion.seed.postgresql;

import com.bbdd2promocion.listener.JobNotificationListener;
import com.bbdd2promocion.model.TestModel;
import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@Configuration
@EnableBatchProcessing
public class TestModelPostgresInsertionJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final SessionFactory sessionFactory;

    public TestModelPostgresInsertionJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, SessionFactory sessionFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sessionFactory = sessionFactory;
    }

    @Bean(name="testModelPostgresReader")
    public FlatFileItemReader<TestModel> testModelPostgresReader() {
        return new FlatFileItemReaderBuilder<TestModel>().name("testModelItemReader")
                .resource(new ClassPathResource("testModel.csv")).delimited()
                .names(new String[] {"csvId", "Title", "Description"})
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<TestModel>() {
                    {
                        setTargetType(TestModel.class);
                        setDistanceLimit(1);
                    }
                }).build();
    }

    @Bean
    public HibernateItemWriter<TestModel> writer() {
        HibernateItemWriter<TestModel> hibernateItemWriter = new HibernateItemWriter<>();
        hibernateItemWriter.setSessionFactory(sessionFactory);
        return hibernateItemWriter;
    }

    @Bean(name="testModelPostgresStep")
    public Step testModelPostgresStep(@Qualifier("testModelPostgresReader") FlatFileItemReader<TestModel> testModelFlatFileItemReader, HibernateItemWriter<TestModel> testModelHibernateItemWriter) {
        return this.stepBuilderFactory.get("testModelStep").<TestModel, TestModel>chunk(2)
                .reader(testModelFlatFileItemReader)
                .writer(testModelHibernateItemWriter)
                .transactionManager(new HibernateTransactionManager(sessionFactory))
                .build();
    }

    @Bean
    public Job testModelPostgresInsertionJob(@Qualifier("testModelPostgresStep") Step step) {
        return this.jobBuilderFactory.get("testModelPostgresInsertionJob").listener(new JobNotificationListener()).start(step).build();
    }

}

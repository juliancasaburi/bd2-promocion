package com.bbdd2promocion.seed.postgresql;

import com.bbdd2promocion.listener.JobNotificationListener;
import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.dto.AccidentDTO;
import com.bbdd2promocion.seed.AccidentItemProcessor;
import com.bbdd2promocion.seed.CommonAccidentSeedingJobConfiguration;
import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@Configuration
@EnableBatchProcessing
@Import(CommonAccidentSeedingJobConfiguration.class)
public class AccidentPostgresInsertionJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final SessionFactory sessionFactory;

    public AccidentPostgresInsertionJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, SessionFactory sessionFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sessionFactory = sessionFactory;
    }

    @Bean(name="accidentHibernateItemWriter")
    public HibernateItemWriter<Accident> writer() {
        HibernateItemWriter<Accident> hibernateItemWriter = new HibernateItemWriter<>();
        hibernateItemWriter.setSessionFactory(sessionFactory);
        return hibernateItemWriter;
    }

    @Bean(name="accidentPostgresStep")
    public Step accidentPostgresStep(@Qualifier("asyncTaskExecutorPostgres") TaskExecutor taskExecutor, FlatFileItemReader<AccidentDTO> accidentFlatFileItemReader, @Qualifier("accidentHibernateItemWriter") HibernateItemWriter<Accident> accidentHibernateItemWriter, AccidentItemProcessor processor) {
        return this.stepBuilderFactory.get("accidentStep")
                .<AccidentDTO, Accident>chunk(10000)
                .reader(accidentFlatFileItemReader)
                .processor(processor)
                .writer(accidentHibernateItemWriter)
                .transactionManager(new HibernateTransactionManager(sessionFactory))
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean(name="asyncTaskExecutorPostgres")
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch_accident_postgres");
    }

    @Bean
    public Job accidentPostgresInsertionJob(@Qualifier("accidentPostgresStep") Step step) {
        return this.jobBuilderFactory.get("accidentPostgresInsertionJob").listener(new JobNotificationListener()).start(step).build();
    }

}

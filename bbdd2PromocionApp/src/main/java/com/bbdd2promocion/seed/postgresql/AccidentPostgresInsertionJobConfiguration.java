package com.bbdd2promocion.seed.postgresql;

import com.bbdd2promocion.listener.JobNotificationListener;
import com.bbdd2promocion.model.Accident;
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
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@EnableBatchProcessing
public class AccidentPostgresInsertionJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final SessionFactory sessionFactory;

    public AccidentPostgresInsertionJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, SessionFactory sessionFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sessionFactory = sessionFactory;
    }

    public ConversionService createConversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        DefaultConversionService.addDefaultConverters(conversionService);
        conversionService.addConverter(new Converter<String, Date>() {
            @Override
            public Date convert(String text) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(text);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return conversionService;
    }

    @Bean(name="accidentPostgresReader")
    public FlatFileItemReader<Accident> accidentPostgresReader() {
        return new FlatFileItemReaderBuilder<Accident>().name("accidentItemReader")
                .resource(new ClassPathResource("US_Accidents_Dec19.csv")).delimited()
                .names(new String[] {"csvId", "source", "tmc", "severity", "startTime", "endTime", "startLat", "startLng", "endLat", "endLng", "distance", "description", "number", "street", "side", "city", "county", "state", "zipcode", "country", "timezone", "airportCode", "weatherTimestamp", "temperature", "windChill", "humidity", "pressure", "visibility", "windDirection", "windSpeed", "precipitation", "weatherCondition", "amenity", "bump", "crossing", "giveWay", "junction", "noExit", "railway", "roundabout", "station", "stop", "trafficCalming", "trafficSignal", "turningLoop", "sunriseSunset", "civilTwilight", "nauticalTwilight", "astronomicalTwilight" })
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Accident>() {
                    {
                        setTargetType(Accident.class);
                        setConversionService(createConversionService());
                        setDistanceLimit(1);
                    }
                }).build();
    }

    @Bean
    public HibernateItemWriter<Accident> writer() {
        HibernateItemWriter<Accident> hibernateItemWriter = new HibernateItemWriter<Accident>();
        hibernateItemWriter.setSessionFactory(sessionFactory);
        return hibernateItemWriter;
    }

    @Bean(name="accidentPostgresStep")
    public Step accidentPostgresStep(TaskExecutor taskExecutor, @Qualifier("accidentPostgresReader") FlatFileItemReader<Accident> accidentFlatFileItemReader, HibernateItemWriter<Accident> accidentHibernateItemWriter) {
        return this.stepBuilderFactory.get("accidentStep")
                .<Accident, Accident>chunk(10000)
                .reader(accidentFlatFileItemReader)
                .writer(accidentHibernateItemWriter)
                .transactionManager(new HibernateTransactionManager(sessionFactory))
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch_accident_postgres");
    }

    @Bean
    public Job accidentPostgresInsertionJob(@Qualifier("accidentPostgresStep") Step step) {
        return this.jobBuilderFactory.get("accidentPostgresInsertionJob").listener(new JobNotificationListener()).start(step).build();
    }

}

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
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.boot.convert.ApplicationConversionService;

import com.bbdd2promocion.model.mongodb.Accident;

@EnableBatchProcessing
public class InsertionJobConfiguration {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    public InsertionJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public FlatFileItemReader<Accident> reader() {
        return new FlatFileItemReaderBuilder<Accident>().name("AccidentItemReader")
                .resource(new ClassPathResource("US_Accidents_Dec19.csv")).delimited()
                .names(new String[] {"id", "source", "tmc", "severity", "startTime", "endTime", "startLat", "startLng", "endLat", "endLng", "distance", "description", "number", "street", "side", "city", "county", "state", "zipcode", "country", "timezone", "airportCode", "weatherTimestamp", "temperature", "windChill", "humidity", "pressure", "visibility", "windDirection", "windSpeed", "precipitation", "weatherCondition", "amenity", "bump", "crossing", "giveWay", "junction", "noExit", "railway", "roundabout", "station", "stop", "trafficCalming", "trafficSignal", "turningLoop", "sunriseSunset", "civilTwilight", "nauticalTwilight", "astronomicalTwilight" })
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Accident>() {
                    {
                        setTargetType(Accident.class);
                        setConversionService(ApplicationConversionService.getSharedInstance());
                        setDistanceLimit(1);
                    }
                }).build();
    }

    @Bean
    public MongoItemWriter<Accident> mongoItemWriter(MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<Accident>().template(mongoTemplate)
                .collection("Accidents")
                .build();
    }

    @Bean
    public Step step(TaskExecutor taskExecutor, FlatFileItemReader<Accident> flatFileIteamReader, MongoItemWriter<Accident> mongoItemWriter) {
        return this.stepBuilderFactory.get("step")
                .<Accident, Accident>chunk(10000)
                .reader(flatFileIteamReader)
                .writer(mongoItemWriter)
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch");
    }

    @Bean
    public Job insertionJob(Step step) {
        return this.jobBuilderFactory.get("insertionJob")
                .listener(new JobNotificationListener())
                .start(step)
                .build();
    }

}

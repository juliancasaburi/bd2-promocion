package com.bbdd2promocion.seed.mongodb;

import com.bbdd2promocion.listener.JobNotificationListener;
import com.bbdd2promocion.model.Accident;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@EnableBatchProcessing
public class InsertionJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    public InsertionJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
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

    @Bean
    public FlatFileItemReader<Accident> reader() {
        return new FlatFileItemReaderBuilder<Accident>().name("AccidentItemReader")
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
    public MongoItemWriter<Accident> mongoItemWriter(MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<Accident>().template(mongoTemplate)
                .collection("Accidents")
                .build();
    }

    @Bean
    public AccidentItemProcessor processor() {
        return new AccidentItemProcessor();
    }

    @Bean
    public Step step(TaskExecutor taskExecutor, FlatFileItemReader<Accident> flatFileIteamReader, MongoItemWriter<Accident> mongoItemWriter, AccidentItemProcessor processor) {
        return this.stepBuilderFactory.get("step")
                .<Accident, Accident>chunk(10000)
                .reader(flatFileIteamReader)
                .processor(processor)
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

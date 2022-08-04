package com.bbdd2promocion.seed;

import com.bbdd2promocion.dto.AccidentDTO;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class CommonAccidentSeedingJobConfiguration {

    private ConversionService createConversionService() {
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

    @Bean(name = "accidentMongoDBReader")
    public FlatFileItemReader<AccidentDTO> reader() {
        return new FlatFileItemReaderBuilder<AccidentDTO>().name("AccidentItemReader")
                .resource(new ClassPathResource("US_Accidents_Dec19.csv")).delimited()
                .names(new String[]{"csvId", "source", "tmc", "severity", "startTime", "endTime", "startLat", "startLng", "endLat", "endLng", "distance", "description", "number", "street", "side", "city", "county", "state", "zipcode", "country", "timezone", "airportCode", "weatherTimestamp", "temperature", "windChill", "humidity", "pressure", "visibility", "windDirection", "windSpeed", "precipitation", "weatherCondition", "amenity", "bump", "crossing", "giveWay", "junction", "noExit", "railway", "roundabout", "station", "stop", "trafficCalming", "trafficSignal", "turningLoop", "sunriseSunset", "civilTwilight", "nauticalTwilight", "astronomicalTwilight"})
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<AccidentDTO>() {
                    {
                        setTargetType(AccidentDTO.class);
                        setConversionService(createConversionService());
                        setDistanceLimit(1);
                    }
                }).build();
    }

    @Bean
    public AccidentItemProcessor processor() {
        return new AccidentItemProcessor();
    }

}

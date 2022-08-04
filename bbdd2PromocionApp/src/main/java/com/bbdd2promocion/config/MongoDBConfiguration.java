package com.bbdd2promocion.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@PropertySource("classpath:application.properties")
public class MongoDBConfiguration extends AbstractMongoClientConfiguration {

    @Autowired
    private Environment env;

    @Override
    public MongoClient mongoClient() {
        String connectionString = "mongodb://" + env.getProperty("spring.data.mongodb.host") + ":" + env.getProperty("spring.data.mongodb.port") + "/" + this.getDatabaseName();
        MongoClient mClient = MongoClients.create(connectionString);
        return mClient;

    }

    @Override
    protected String getDatabaseName() {
        return env.getProperty("spring.data.mongodb.database");
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(this.mongoClient(), this.getDatabaseName());
    }

}
package com.bbdd2promocion.seed.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfiguration extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.host:mongodb}")
    private String mongodbHost;

    @Value("${spring.data.mongodb.port:27017}")
    private String mongodbPort;

    @Value("${spring.data.mongodb.database:bbdd2_promocion}")
    private String mongodbDatabase;

    @Override
    protected String getDatabaseName() {
        return mongodbDatabase;
    }

    @Override
    public MongoClient mongoClient() {
        String connectionString = "mongodb://" + this.mongodbHost + ":" + Integer.parseInt(this.mongodbPort) + "/" + this.getDatabaseName();
        MongoClient mClient = MongoClients.create(connectionString);
        return mClient;

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
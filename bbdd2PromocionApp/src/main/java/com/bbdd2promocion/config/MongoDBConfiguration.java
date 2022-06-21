package com.bbdd2promocion.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfiguration extends AbstractMongoClientConfiguration {

    private final String mongodbHost;

    private final String mongodbPort;

    private final String mongodbDatabase;

    public MongoDBConfiguration(Environment env) throws JSONException {
        JSONObject springProperties = new JSONObject(env.getProperty("SPRING_APPLICATION_JSON"));
        this.mongodbHost = springProperties.getString("spring.data.mongodb.host");
        this.mongodbPort = springProperties.getString("spring.data.mongodb.port");
        this.mongodbDatabase = springProperties.getString("spring.data.mongodb.database");
    }

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
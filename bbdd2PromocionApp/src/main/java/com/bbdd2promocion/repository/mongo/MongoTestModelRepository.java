package com.bbdd2promocion.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bbdd2promocion.model.TestModel;

/**
 * Repositorio de TestModel para bases de datos Mongo.
 *
 */
//@Repository
public interface MongoTestModelRepository extends MongoRepository<TestModel, String> {
    public List<TestModel> findByDescription(String description);
}
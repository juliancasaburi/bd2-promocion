package com.bbdd2promocion.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bbdd2promocion.model.TestModel;

/**
 * Repositorio de TestModel para bases de datos Mongo.
 *
 */
//@Repository
public interface MongoTestModelRepository extends MongoRepository<TestModel, UUID> {
}

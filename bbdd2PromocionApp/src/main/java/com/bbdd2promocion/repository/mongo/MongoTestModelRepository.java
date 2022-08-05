package com.bbdd2promocion.repository.mongo;

import com.bbdd2promocion.model.TestModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Repositorio de TestModel para bases de datos Mongo. */
@Repository
public interface MongoTestModelRepository extends MongoRepository<TestModel, String> {
  List<TestModel> findByDescription(String description);
}

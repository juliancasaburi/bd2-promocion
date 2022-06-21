/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.bbdd2promocion.service.impl;

import com.bbdd2promocion.dto.DTOFactory;
import com.bbdd2promocion.dto.TestModelDTO;
import com.bbdd2promocion.model.TestModel;
import com.bbdd2promocion.repository.jpa.JPATestModelRepository;
import com.bbdd2promocion.repository.mongo.MongoTestModelRepository;
import com.bbdd2promocion.service.ITestModelService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * TestModel.
 */
@Service
@Transactional
public class TestModelServiceImpl implements ITestModelService {

    /**
     * Es el repositorio ligado a los TestModel.
     */
    @Inject
    private JPATestModelRepository testModelPostgresRepository;

    @Inject
    private MongoTestModelRepository testModelMongoRepository;

    /**
     * Es el objeto encargado de crear los DTOs.
     */
    @Inject
    private DTOFactory dtoFactory;

    @Override
    public List<TestModel> findAllPostgres() {
        return this.getTestModelPostgresRepository().findAll();
    }

    @Override
    public List<TestModel> findAllMongo() {
        return this.getTestModelMongoRepository().findAll();
    }

    @Override
    public List<TestModel> findByDescription(String description) {
        return this.getTestModelMongoRepository().findByDescription(description);
    }

    @Override
    public TestModelDTO addTestModel(String id, String aTitle, String aDescription) {

        TestModel newTestModel = new TestModel(id, aTitle, aDescription);

        this.getTestModelMongoRepository().save(newTestModel);

        this.getTestModelPostgresRepository().save(newTestModel);

        return this.getDtoFactory().createTestModelDTO(newTestModel);
    }

    /**
     * Getter.
     *
     * @return el repositorio de TestModel (PostgreSQL).
     */
    public JPATestModelRepository getTestModelPostgresRepository() {
        return this.testModelPostgresRepository;
    }

    /**
     * Getter.
     *
     * @return el repositorio de TestModel (MongoDB).
     */
    public MongoTestModelRepository getTestModelMongoRepository() {
        return this.testModelMongoRepository;
    }

    /**
     * Getter.
     *
     * @return el objeto que debe utilizarse para crear los DTOs.
     */
    public DTOFactory getDtoFactory() {
        return this.dtoFactory;
    }
}

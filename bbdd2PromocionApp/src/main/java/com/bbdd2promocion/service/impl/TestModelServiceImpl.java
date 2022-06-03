/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.bbdd2promocion.service.impl;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bbdd2promocion.dto.DTOFactory;
import com.bbdd2promocion.dto.TestModelDTO;
import com.bbdd2promocion.model.TestModel;
import com.bbdd2promocion.repository.JPATestModelRepository;
import com.bbdd2promocion.repository.MongoTestModelRepository;
import com.bbdd2promocion.service.ITestModelService;

/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * usuarios.
 */
@Service
@Transactional
public class TestModelServiceImpl implements ITestModelService {

    /**
     * Es el repositorio ligado a los TestModel.
     */
    @Inject
    private JPATestModelRepository testModelRepository;

    /**
     * Es el repositorio de Mongo ligado a los TestModel.
     */
    @Inject
    private MongoTestModelRepository mongoTestModelRepository;

    /**
     * Es el objeto encargado de crear los DTOs.
     */
    @Inject
    private DTOFactory dtoFactory;

    @Override
    public List<TestModel> findAll() {
        return this.getTestModelRepository().findAll();
    }

    @Override
    public TestModelDTO addTestModel(String aTitle, String aDescription) {

        TestModel newTestModel = new TestModel(aTitle, aDescription);

        this.getTestModelRepository().save(newTestModel);
        this.getMongoTestModelRepository().save(newTestModel);

        return this.getDtoFactory().createTestModelDTO(newTestModel);
    }

    /**
     * Getter.
     *
     * @return el repositorio de TestModel.
     */
    public JPATestModelRepository getTestModelRepository() {
        return this.testModelRepository;
    }

    /**
     * Getter.
     *
     * @return el repositorio de mongo de TestModel.
     */
    public MongoTestModelRepository getMongoTestModelRepository() {
        return this.mongoTestModelRepository;
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

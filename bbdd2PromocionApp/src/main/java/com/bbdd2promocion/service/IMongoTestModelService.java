/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.bbdd2promocion.service;

import java.util.List;

import com.bbdd2promocion.model.mongodb.TestModel;
import com.bbdd2promocion.dto.MongoTestModelDTO;

/**
 * Esta interface define el comportamiento esperado por los servicios
 * relacionados con los TestModel.
 */
public interface IMongoTestModelService {

    /**
     * Retorna todos los TestModel.
     *
     * @return todos los TestModel.
     */
    public List<TestModel> findAll();

    /**
     * Retorna todos los TestModel.
     *
     * @param aDescription es la description del TestModel.
     * @return todos los TestModel.
     */
    public List<TestModel> findByDescription(String aDescription);

    /**
     * Agrega un nuevo TestModel.
     *
     * @param aTitle es el title del TestModel.
     * @param aDescription es la description del TestModel
     * @return un DTO que representa al TestModel recientemete creado.
     */
    public MongoTestModelDTO addTestModel(String aTitle, String aDescription);

}

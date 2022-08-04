/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.bbdd2promocion.service;

import com.bbdd2promocion.dto.TestModelDTO;
import com.bbdd2promocion.model.TestModel;

import java.util.List;

/**
 * Esta interface define el comportamiento esperado por los servicios
 * relacionados con los TestModel.
 */
public interface ITestModelService {

    /**
     * Retorna todos los TestModel (MongoDB).
     *
     * @return todos los TestModel.
     */
    List<TestModel> findAllMongo();

    /**
     * Retorna todos los TestModel (PostgreSQL)
     *
     * @return todos los TestModel.
     */
    List<TestModel> findAllPostgres();

    /**
     * Retorna todos los TestModel cuya description sea igual a aDescription.
     *
     * @param aDescription es la description del TestModel.
     * @return todos los TestModel.
     */
    List<TestModel> findByDescription(String aDescription);

    /**
     * Agrega un nuevo TestModel.
     *
     * @param id es el id del TestModel.
     * @param aTitle es el title del TestModel.
     * @param aDescription es la description del TestModel
     * @return un DTO que representa al TestModel recientemete creado.
     */
    TestModelDTO addTestModel(String id, String aTitle, String aDescription);

}

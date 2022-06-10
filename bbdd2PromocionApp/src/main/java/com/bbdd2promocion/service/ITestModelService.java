/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.bbdd2promocion.service;

import java.util.List;

import com.bbdd2promocion.model.postgresql.TestModel;
import com.bbdd2promocion.dto.TestModelDTO;

/**
 * Esta interface define el comportamiento esperado por los servicios
 * relacionados con los TestModel.
 */
public interface ITestModelService {

    /**
     * Retorna todos los TestModel.
     *
     * @return todos los TestModel.
     */
    public List<TestModel> findAll();

    /**
     * Agrega un nuevo TestModel.
     *
     * @param aTitle es el title del TestModel.
     * @param aDescription es la description del TestModel
     * @return un DTO que representa al TestModel recientemete creado.
     */
    public TestModelDTO addTestModel(String aTitle, String aDescription);

}

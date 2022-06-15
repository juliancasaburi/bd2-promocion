/**
 * Este paquete contiene las implementaciones de los repositorios personalizados.
 */
package com.bbdd2promocion.repository.jpa.impl;

import com.bbdd2promocion.repository.jpa.CustomTestModelRepository;

/**
 * Esta clase implementa los mecanismos personalizados de recuperación de
 * información.
 */
public class CustomTestModelRepositoryImpl implements CustomTestModelRepository {
    /**
     * Obtiene la cantidad de TestModel.
     *
     * @return el número de TestModel.
     */
    @Override
    public int getNumberOfTestModels() {
// 	resultado de ejemplo. Acá va la consulta real
        return 4;
    }
}

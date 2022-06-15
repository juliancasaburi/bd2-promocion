/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.bbdd2promocion.repository.jpa;

/**
 * Esta interface define el comportamiento extra que debe cumplir un repositorio
 * de TestModel.
 */
public interface CustomTestModelRepository {

    /**
     * Obtiene la cantidad de usuarios que tienen la misma clave.
     *
     * @return el número de usuarios.
     */
    public int getNumberOfTestModels();
}

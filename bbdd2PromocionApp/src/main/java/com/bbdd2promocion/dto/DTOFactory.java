/**
 * Este paquete contiene las clases que se utilizan para transferir información de las
 * distintas instancias entre capas.
 */
package com.bbdd2promocion.dto;

import org.springframework.stereotype.Component;

/**
 * Las instancias de esta clase se utilizan para crear DTOs en forma
 * centralizada.
 */
@Component
public class DTOFactory {

	/**
	 * Crea un DTO que representará a un TestModel.
	 *
	 * @param aTestModel es el TestModel que debe ser representado.
	 * @return un DTO con los datos básicos.
	 */
	public TestModelDTO createTestModelDTO(com.bbdd2promocion.model.postgres.TestModel aTestModel) {
		return new TestModelDTO(aTestModel.getId(), aTestModel.getTitle(), aTestModel.getDescription());
	}

	/**
	 * Crea un DTO que representará a un TestModel.
	 *
	 * @param aTestModel es el TestModel que debe ser representado.
	 * @return un DTO con los datos básicos.
	 */
	public MongoTestModelDTO createMongoTestModelDTO(com.bbdd2promocion.model.mongodb.TestModel aTestModel) {
		return new MongoTestModelDTO(aTestModel.getId(), aTestModel.getTitle(), aTestModel.getDescription());
	}

}

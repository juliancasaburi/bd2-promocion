/**
 * Este paquete contiene las clases que se utilizan para transferir información de las
 * distintas instancias entre capas.
 */
package com.bbdd2promocion.dto;

import com.bbdd2promocion.model.TestModel;
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
	public TestModelDTO createTestModelDTO(TestModel aTestModel) {
		return new TestModelDTO(aTestModel.getCsvId(), aTestModel.getTitle(), aTestModel.getDescription());
	}

}

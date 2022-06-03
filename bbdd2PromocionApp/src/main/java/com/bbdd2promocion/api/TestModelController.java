package com.bbdd2promocion.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbdd2promocion.model.TestModel;

import com.bbdd2promocion.service.ITestModelService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TestModelController {

	/**
	 * Es el servicio relacionado con los TestModel.
	 */
	@Inject
	public ITestModelService testModelsService;

	/**
	 * Getter.
	 *
	 * @return el servicio relacionado con los TestModel.
	 */
	private ITestModelService getTestModelsService() {
		return this.testModelsService;
	}

	@GetMapping("/testModel")
	public ResponseEntity<List<TestModel>> getAllTestModels() {
		return new ResponseEntity<>(this.getTestModelsService().findAll(), HttpStatus.OK);
	}

}

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
import org.springframework.web.bind.annotation.RequestParam;

import com.bbdd2promocion.model.postgres.TestModel;

import com.bbdd2promocion.service.ITestModelService;
import com.bbdd2promocion.service.IMongoTestModelService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TestModelController {

	/**
	 * Es el servicio relacionado con los TestModel (MongoDB).
	 */
	@Inject
	public IMongoTestModelService mongoTestModelService;

	/**
	 * Es el servicio relacionado con los TestModel (PostgreSQL).
	 */
	@Inject
	public ITestModelService testModelService;

	/**
	 * Getter.
	 *
	 * @return el servicio relacionado con los TestModel.
	 */
	private ITestModelService getTestModelService() {
		return this.testModelService;
	}

	/**
	 * Getter.
	 *
	 * @return el servicio relacionado con los TestModel.
	 */
	private IMongoTestModelService getMongoTestModelService() {
		return this.mongoTestModelService;
	}

	@GetMapping("/testModel")
	public ResponseEntity<List<com.bbdd2promocion.model.postgres.TestModel>> getAllTestModels() {
		return new ResponseEntity<>(this.getTestModelService().findAll(), HttpStatus.OK);
	}

	@GetMapping("/testModelMongo")
	public ResponseEntity<List<com.bbdd2promocion.model.mongodb.TestModel>> getAllMongoTestModels() {
		return new ResponseEntity<>(this.getMongoTestModelService().findAll(), HttpStatus.OK);
	}

	@GetMapping("/testModelMongoDescription")
	public ResponseEntity<List<com.bbdd2promocion.model.mongodb.TestModel>> getMongoTestModelsDescription(@RequestParam(name = "description") String aDescription) {
		return new ResponseEntity<>(this.getMongoTestModelService().findByDescription(aDescription), HttpStatus.OK);
	}

}

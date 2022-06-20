package com.bbdd2promocion.api;

import java.util.List;

import javax.inject.Inject;

import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.model.TestModel;
import com.bbdd2promocion.service.IAccidentService;
import com.bbdd2promocion.service.ISeedingService;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.JobParametersInvalidException;

import com.bbdd2promocion.service.ITestModelService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class APIController {

	/**
	 * Es el servicio relacionado con los TestModel.
	 */
	@Inject
	public ITestModelService testModelService;

	/**
	 * Es el servicio relacionado con los Accident.
	 */
	@Inject
	public IAccidentService accidentService;

	/**
	 * Es el servicio relacionado con los seeding jobs.
	 */
	@Inject
	public ISeedingService seedingService;

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
	 * @return el servicio relacionado con los Accident.
	 */
	private IAccidentService getAccidentService() {
		return this.accidentService;
	}

	/**
	 * Getter.
	 *
	 * @return el servicio relacionado con los seeding jobs.
	 */
	private ISeedingService getSeedingService() {
		return this.seedingService;
	}

	@PostMapping("/seed/mongodb/testModel")
	public ResponseEntity seedTestModelMongoDB() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
		this.getSeedingService().seedTestModelMongoDB();
		return ResponseEntity.status(HttpStatus.OK).body("mongodb testModel seeding job started");
	}

	@PostMapping("/seed/mongodb/accident")
	public ResponseEntity seedAccidentMongoDB() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
		this.getSeedingService().seedAccidentMongoDB();
		return ResponseEntity.status(HttpStatus.OK).body("mongodb accident seeding job started");
	}

	@PostMapping("/seed/postgresql/testModel")
	public ResponseEntity seedTestModelPostgreSQL() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
		this.getSeedingService().seedTestModelPostgreSQL();
		return ResponseEntity.status(HttpStatus.OK).body("postgresql testModel seeding job started");
	}

	@GetMapping("/testModelPostgres")
	public ResponseEntity<List<TestModel>> getAllTestModels() {
		return new ResponseEntity<>(this.getTestModelService().findAllPostgres(), HttpStatus.OK);
	}

	@GetMapping("/testModelMongo")
	public ResponseEntity<List<TestModel>> getAllMongoTestModels() {
		return new ResponseEntity<>(this.getTestModelService().findAllMongo(), HttpStatus.OK);
	}

	@GetMapping("/accidentsNear")
	public ResponseEntity<List<Accident>> getAccidentsNear(
			@RequestParam(name = "longitude") String longitude,
			@RequestParam(name = "latitude") String latitude,
			@RequestParam(name = "radius") String distance
	) {
		return new ResponseEntity<>(this.getAccidentService().findByStartLocationNear(
				new GeoJsonPoint(Double.parseDouble(longitude), Double.parseDouble(latitude)),
				new Distance(Double.parseDouble(distance), Metrics.KILOMETERS)
		), HttpStatus.OK);
	}

	@GetMapping("/testModelMongoDescription")
	public ResponseEntity<List<TestModel>> getMongoTestModelsDescription(@RequestParam(name = "description") String aDescription) {
		return new ResponseEntity<>(this.getTestModelService().findByDescription(aDescription), HttpStatus.OK);
	}

}

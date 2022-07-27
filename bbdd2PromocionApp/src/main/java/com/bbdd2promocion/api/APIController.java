package com.bbdd2promocion.api;

import com.bbdd2promocion.helpers.ConditionValues;
import com.bbdd2promocion.repository.jpa.projections.ValueCount;
import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.model.TestModel;
import com.bbdd2promocion.repository.jpa.projections.StreetStatistics;
import com.bbdd2promocion.repository.mongo.projections.LocationCount;
import com.bbdd2promocion.service.IAccidentService;
import com.bbdd2promocion.service.ISeedingService;
import com.bbdd2promocion.service.ITestModelService;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

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
    public ResponseEntity seedTestModelMongoDB() throws JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        this.getSeedingService().seedTestModelMongoDB();
        return ResponseEntity.status(HttpStatus.OK).body("mongodb testModel seeding job started");
    }

    @PostMapping("/seed/mongodb/accident")
    public ResponseEntity seedAccidentMongoDB() throws JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        this.getSeedingService().seedAccidentMongoDB();
        return ResponseEntity.status(HttpStatus.OK).body("mongodb accident seeding job started");
    }

    @PostMapping("/seed/postgresql/testModel")
    public ResponseEntity seedTestModelPostgreSQL() throws JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        this.getSeedingService().seedTestModelPostgreSQL();
        return ResponseEntity.status(HttpStatus.OK).body("postgresql testModel seeding job started");
    }

    @PostMapping("/seed/postgresql/accident")
    public ResponseEntity seedAccidentPostgreSQL() throws JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        this.getSeedingService().seedAccidentPostgreSQL();
        return ResponseEntity.status(HttpStatus.OK).body("postgresql accident seeding job started");
    }

    @GetMapping("/testModelPostgres")
    public ResponseEntity<List<TestModel>> getAllTestModels() {
        return new ResponseEntity<>(this.getTestModelService().findAllPostgres(), HttpStatus.OK);
    }

    @GetMapping("/testModelMongo")
    public ResponseEntity<List<TestModel>> getAllMongoTestModels() {
        return new ResponseEntity<>(this.getTestModelService().findAllMongo(), HttpStatus.OK);
    }

    @GetMapping("/withinRadius")
    public ResponseEntity<List<Accident>> getAccidentsWithinRadius(
            @RequestParam(name = "longitude") String longitude,
            @RequestParam(name = "latitude") String latitude,
            @RequestParam(name = "radius") String radius) {
        return new ResponseEntity<>(this.getAccidentService().findByStartLocationWithinRadius(
                new Circle(
                        new Point(Double.parseDouble(longitude), Double.parseDouble(latitude)),
                        new Distance(Double.parseDouble(radius), Metrics.KILOMETERS))),
                HttpStatus.OK);
    }

    @GetMapping("/averageDistance")
    public ResponseEntity<Double> getAverageDistance() {
        return new ResponseEntity<>(this.getAccidentService().getAverageDistance(), HttpStatus.OK);
    }

    @GetMapping("/betweenDates")
    public ResponseEntity<List<Accident>> findBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        return new ResponseEntity<>(this.getAccidentService().findBetweenDates(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("/streetsMostAccidents")
    public ResponseEntity<List<StreetStatistics>> getStreetsMostAccidents(
            @RequestParam(name = "limit", required = false, defaultValue = "5") int limit) {
        return new ResponseEntity<>(this.getAccidentService().getStreetsWithMostAccidents(limit), HttpStatus.OK);
    }

    @GetMapping("/mostDangerousPointsWithinRadius")
    public ResponseEntity<List<LocationCount>> getMostDangerousPointsWithinRadius(
            @RequestParam(name = "longitude") Double longitude,
            @RequestParam(name = "latitude") Double latitude,
            @RequestParam(name = "radius") String radius,
            @RequestParam(name = "limit", required = false, defaultValue = "5") int limit) {
        return new ResponseEntity<>(this.getAccidentService().getMostDangerousPointsWithinRadius(
                longitude,
                latitude,
                Double.parseDouble(radius) / 6378.1, // 6378.1 = radius of earth in Km,
                limit), HttpStatus.OK);
    }

    @GetMapping("/mostCommonConditions/weather")
    public ResponseEntity<List<ConditionValues>> getMostCommonWeatherConditions() {
        return new ResponseEntity<>(this.getAccidentService().getMostCommonWeatherConditions(), HttpStatus.OK);
    }

    @GetMapping("/mostCommonConditions/hour")
    public ResponseEntity<ValueCount> getMostCommonHourConditions() {
        return new ResponseEntity<>(this.getAccidentService().getMostCommonHourConditions(), HttpStatus.OK);
    }

    @GetMapping("/testModelMongoDescription")
    public ResponseEntity<List<TestModel>> getMongoTestModelsDescription(
            @RequestParam(name = "description") String aDescription) {
        return new ResponseEntity<>(this.getTestModelService().findByDescription(aDescription), HttpStatus.OK);
    }

}

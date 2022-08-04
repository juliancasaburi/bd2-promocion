package com.bbdd2promocion.helpers;

import com.bbdd2promocion.repository.mongo.MongoAccidentRepository;
import com.bbdd2promocion.repository.mongo.projections.Distance;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AverageDistanceHelper {

    private final MongoAccidentRepository accidentMongoRepository;

    private Double averageDistance = 0.0;

    private int processedAccidents = 0;

    private final int kNearestNeighbors;

    public AverageDistanceHelper(MongoAccidentRepository accidentMongoRepository, int kNearestNeighbors) {
        this.accidentMongoRepository = accidentMongoRepository;
        this.kNearestNeighbors = kNearestNeighbors;
    }

    public void calc(Double longitude, Double latitude){
        // calc & update averageDistance
        processedAccidents += 1;
        List<Distance> distances = this.getNearestNeighbors(longitude, latitude).getMappedResults();
        AtomicReference<Double> sumDistances = new AtomicReference<>(0.0);
        distances.forEach(d -> sumDistances.set(sumDistances.get() + d.getDistance()));
        averageDistance += (sumDistances.get() / kNearestNeighbors);
    }

    public Double getAverageDistance() {
        return averageDistance / processedAccidents;
    }

    private AggregationResults<Distance> getNearestNeighbors(Double longitude, Double latitude){
        return this.getAccidentMongoRepository().findAverageDistanceAccidents(longitude, latitude, kNearestNeighbors);
    }

    /**
     * Getter.
     *
     * @return el repositorio de Accident (MongoDB).
     */
    private MongoAccidentRepository getAccidentMongoRepository() {
        return this.accidentMongoRepository;
    }
}

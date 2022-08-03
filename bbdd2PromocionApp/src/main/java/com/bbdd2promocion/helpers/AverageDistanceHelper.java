package com.bbdd2promocion.helpers;

import com.bbdd2promocion.repository.mongo.MongoAccidentRepository;
import com.bbdd2promocion.repository.mongo.projections.Distance;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AverageDistanceHelper {

    @Inject
    private MongoAccidentRepository accidentMongoRepository;

    private Double averageDistance = 0.0;

    private int kNearestNeighbors;

    public AverageDistanceHelper(Integer kNearestNeighbors) {
        this.kNearestNeighbors = kNearestNeighbors;
    }

    public void calc(Double longitude, Double latitude){
        // calc & update averageDistance
        List<Distance> distances = this.getNearestNeighbors(longitude, latitude).getMappedResults();
        AtomicReference<Double> sumDistances = new AtomicReference<>(0.0);
        distances.stream().forEach(d -> sumDistances.updateAndGet(v -> v + d.getDistance()));
        averageDistance = sumDistances.get() / kNearestNeighbors;
    }

    public int getkNearestNeighbors() {
        return kNearestNeighbors;
    }

    public void setkNearestNeighbors(int kNearestNeighbors) {
        this.kNearestNeighbors = kNearestNeighbors;
    }

    public Double getAverageDistance() {
        return averageDistance;
    }

    private AggregationResults<Distance> getNearestNeighbors(Double longitude, Double latitude){
        return this.getAccidentMongoRepository().findAverageDistanceAccidents(longitude, latitude, kNearestNeighbors);
    }

    /**
     * Getter.
     *
     * @return el repositorio de Accident (MongoDB).
     */
    public MongoAccidentRepository getAccidentMongoRepository() {
        return this.accidentMongoRepository;
    }
}

package com.bbdd2promocion.repository.mongo;

import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.repository.mongo.projections.LocationCount;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoAccidentRepository extends MongoRepository<Accident, String> {

    List<Accident> findByStartLocationWithin(Circle circle);

    @Aggregation(pipeline = {
            "{\n" +
            "        $geoNear: {\n" +
            "            near: { type: \"Point\", coordinates: [?0, ?1] },\n" +
            "            distanceField: \"dist.calculated\",\n" +
            "            maxDistance: ?2,\n" +
            "            spherical: true,\n" +
            "        }\n" +
            "    }",
            "{ $sortByCount: \"$startLocation.coordinates\" }",
            "{ $limit: ?3 }",
            "{ $addFields: { startLocation: \"$_id\" } }",
            "{ $unset: [\"_id\"] }"
    })
    AggregationResults<LocationCount> findMostDangerousPointsWithinRadius(Double longitude, Double latitude, int radius, int limit);
}


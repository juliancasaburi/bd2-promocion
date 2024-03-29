package com.bbdd2promocion.repository.mongo;

import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.repository.mongo.projections.HourCount;
import com.bbdd2promocion.repository.mongo.projections.LocationCount;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Meta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoAccidentRepository extends MongoRepository<Accident, String> {

  List<Accident> findByAccidentLocationData_StartLocationWithin(Circle circle);

  @Aggregation(
      pipeline = {
        "{\n"
            + "\"$match\": {\n"
            + "\"accidentLocationData.startLocation\": {\n"
            + "      \"$geoWithin\": {\n"
            + "         \"$centerSphere\": [\n"
            + "           [?0, ?1], ?2\n"
            + "         ]\n"
            + "      }\n"
            + "    }\n"
            + "    }\n"
            + "    }",
        "{ $sortByCount: \"$accidentLocationData.startLocation.coordinates\" }",
        "{ $limit: ?3 }",
        "{ $addFields: { startLocation: \"$_id\" } }",
        "{ $unset: [\"_id\"] }"
      })
  @Meta(allowDiskUse = true)
  AggregationResults<LocationCount> findMostDangerousPointsWithinRadius(
      Double longitude, Double latitude, Double radius, int limit);

  @Aggregation(
      pipeline = {
        "{\n"
            + "\"$project\": {\n"
            + "\"hour\": {\n"
            + "      \"$hour\": \n"
            + "         \"$startTime\" \n"
            + "    }\n"
            + "    }\n"
            + "    }",
        "{ $sortByCount: \"$hour\" }",
        "{ $limit: 1 }",
        "{ $addFields: { hour: \"$_id\" } }",
        "{ $unset: [\"_id\"] }"
      })
  AggregationResults<HourCount> findMostCommonHour();
}

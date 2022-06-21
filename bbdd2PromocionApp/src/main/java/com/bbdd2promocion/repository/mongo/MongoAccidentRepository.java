package com.bbdd2promocion.repository.mongo;

import com.bbdd2promocion.model.Accident;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repositorio de Accident para bases de datos Mongo.
 *
 */
//@Repository
public interface MongoAccidentRepository extends MongoRepository<Accident, String> {

    // { 'startLocation' : { '$near' : [point.x, point.y], '$maxDistance' : distance}}
    List<Accident> findByStartLocationNear(Point location, Distance distance);
}
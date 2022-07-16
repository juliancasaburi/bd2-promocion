/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.bbdd2promocion.service.impl;

import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.repository.jpa.JPAAccidentRepository;
import com.bbdd2promocion.repository.mongo.MongoAccidentRepository;
import com.bbdd2promocion.service.IAccidentService;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * Accident.
 */
@Service
@Transactional
public class AccidentServiceImpl implements IAccidentService {

    /**
     * Es el repositorio ligado a los Accident
     */

    @Inject
    private MongoAccidentRepository accidentMongoRepository;

    @Inject
    private JPAAccidentRepository jpaAccidentRepository;

    @Override
    public List<Accident> findByStartLocationNear(Point location, Distance distance) {
        return this.getAccidentMongoRepository().findByStartLocationNear(location, distance);
    }

    @Override
    public Double getAverageDistance() {
        return this.getAccidentJPARepository().getAverageDistance();
    }

    /**
     * Getter.
     *
     * @return el repositorio de Accident (MongoDB).
     */
    public MongoAccidentRepository getAccidentMongoRepository() {
        return this.accidentMongoRepository;
    }

    /**
     * Getter.
     *
     * @return el repositorio de Accident (JPA).
     */
    public JPAAccidentRepository getAccidentJPARepository() {
        return this.jpaAccidentRepository;
    }
}

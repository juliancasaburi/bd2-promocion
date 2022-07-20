/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.bbdd2promocion.service;

import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.repository.jpa.projections.StreetStatistics;
import com.bbdd2promocion.repository.mongo.projections.LocationCount;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.util.Date;
import java.util.List;

/**
 * Esta interface define el comportamiento esperado por los servicios
 * relacionados con los Accident.
 */
public interface IAccidentService {

    /**
     * Retorna los Accident ocurridos dentro del radio
     *
     * @return los Accident ocurridos dentro del radio
     */
    List<Accident> findByStartLocationNear(Point location, Distance distance);

    /**
     * Obtiene la distancia promedio desde el inicio al fin del accidente
     *
     * @return la distancia promedio desde el inicio al fin del accidente
     */
    Double getAverageDistance();

    /**
     * Retorna los Accident con date entre startDate y endDate
     *
     * @param startDate
     * @param endDate
     * @return los Accident con date entre startDate y endDate
     */
    List<Accident> findBetweenDates(Date startDate, Date endDate);

    /**
     * Retorna las N calles con mas accidentes
     *
     * @param limit
     * @return las N calles con mas accidentes
     */
    List<StreetStatistics> getStreetsWithMostAccidents(int limit);

    /**
     * Retorna los n puntos mas peligrosos dentro de un radio dada una latitud y longitud
     *
     * @param longitude
     * @param latitude
     * @param radius
     * @param limit
     *
     * @return los n puntos mas peligrosos dentro de un radio dada una latitud y longitud
     */
    List<LocationCount> getMostDangerousPointsWithinRadius(Double longitude, Double latitude, int radius, int limit);

}

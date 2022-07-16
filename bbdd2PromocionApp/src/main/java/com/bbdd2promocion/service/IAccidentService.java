/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.bbdd2promocion.service;

import com.bbdd2promocion.model.Accident;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

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

}

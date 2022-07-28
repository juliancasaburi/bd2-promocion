package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.repository.jpa.projections.ValueCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JPAAccidentRepository extends JpaRepository<Accident, Long> {

    /**
     * Obtiene la distancia promedio desde el inicio al fin del accidente
     *
     * @return la distancia promedio desde el inicio al fin del accidente.
     */
    @Query("SELECT AVG(a.distance) FROM Accident a")
    Double getAverageDistance();

    /**
     * Recupera los Accident con date entre startDate y endDate
     *
     * @param startDate
     * @param endDate
     * @return los Accident con date entre startDate y endDate
     */
    List<Accident> findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(Date startDate, Date endDate);


    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad hora
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad hora
     */
    @Query("SELECT EXTRACT(HOUR FROM a.startTime) as value, count(a) as count  \n" +
            "from Accident a \n" +
            "group by EXTRACT(HOUR FROM a.startTime) \n" +
            "order by count(EXTRACT(HOUR FROM a.startTime)) desc \n")
    List<ValueCount> findMostCommonHour(Pageable pageable);

}

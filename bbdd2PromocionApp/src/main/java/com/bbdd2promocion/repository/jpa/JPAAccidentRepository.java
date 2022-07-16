package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JPAAccidentRepository extends JpaRepository<Accident, Long>, CustomTestModelRepository {

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

}

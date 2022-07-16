package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAAccidentRepository extends JpaRepository<Accident, Long>, CustomTestModelRepository {

    /**
     * Obtiene la distancia promedio desde el inicio al fin del accidente
     *
     * @return la distancia promedio desde el inicio al fin del accidente.
     */
    @Query("SELECT AVG(a.distance) FROM Accident a")
    Double getAverageDistance();

}

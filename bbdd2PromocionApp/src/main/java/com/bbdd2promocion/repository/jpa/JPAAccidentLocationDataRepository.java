package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.AccidentLocationData;
import com.bbdd2promocion.repository.jpa.projections.StreetStatistics;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAAccidentLocationDataRepository extends JpaRepository<AccidentLocationData, Long> {

    /**
     * Retorna datos de las N (pageable) calles con mas accidentes
     *
     * @param pageable
     * @return datos (StreetStatistics) de las N (pageable) calles con mas
     *         accidentes
     */
    @Query("SELECT ald.street as street, ald.zipcode as zipcode, COUNT(ald) as count FROM AccidentLocationData ald GROUP BY ald.street, ald.zipcode ORDER BY COUNT(ald) DESC")
    List<StreetStatistics> getStreetsWithMostAccidents(Pageable pageable);

}

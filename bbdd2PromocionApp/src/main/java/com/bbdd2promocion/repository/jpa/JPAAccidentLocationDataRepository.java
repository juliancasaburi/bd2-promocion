package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.AccidentLocationData;
import com.bbdd2promocion.repository.jpa.projections.StreetStatistics;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JPAAccidentLocationDataRepository
    extends JpaRepository<AccidentLocationData, Long> {

  /**
   * Retorna datos de las N (pageable) calles con mas accidentes
   *
   * @param pageable
   * @return datos (StreetStatistics) de las N (pageable) calles con mas accidentes
   */
  @Query(
      "SELECT ald.street as street, ald.zipcode as zipcode, COUNT(ald) as count FROM AccidentLocationData ald GROUP BY ald.street, ald.zipcode ORDER BY COUNT(ald) DESC")
  List<StreetStatistics> getStreetsWithMostAccidents(Pageable pageable);

  @Query(
      nativeQuery = true,
      value =
          "select avg(dist)\n"
              + "from (select dist\n"
              + "      from accident_location_data ald\n"
              + "               cross join lateral (\n"
              + "          select ald2.point,\n"
              + "                 ald2.point <-> ald.point as dist\n"
              + "          from accident_location_data ald2\n"
              + "          order by dist\n"
              + "          limit ?1\n"
              + "          ) ald2) calc")
  Double getAverageDistanceKNN(int k);

  @Modifying
  @Transactional()
  @Query(
      nativeQuery = true,
      value =
          "CREATE INDEX IF NOT EXISTS accident_location_data_point_idx\n"
              + "  ON accident_location_data\n"
              + "  USING GIST (point);")
  void createPostGISIndex();
}

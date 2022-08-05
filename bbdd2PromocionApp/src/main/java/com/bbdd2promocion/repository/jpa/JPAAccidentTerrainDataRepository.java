package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.AccidentTerrainData;
import com.bbdd2promocion.repository.jpa.projections.ValueCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAAccidentTerrainDataRepository extends JpaRepository<AccidentTerrainData, Long> {

  /**
   * Retorna el valor con mayor cantidad de repeticiones para la propiedad crossing
   *
   * @param pageable
   * @return el valor con mayor cantidad de repeticiones para la propiedad crossing
   */
  @Query(
      "select atd.crossing as value, count(atd) as count \n"
          + "from AccidentTerrainData atd \n"
          + "group by atd.crossing \n"
          + "order by count(atd.crossing) desc \n")
  List<ValueCount> findMostCommonCrossing(Pageable pageable);

  /**
   * Retorna el valor con mayor cantidad de repeticiones para la propiedad giveWay
   *
   * @param pageable
   * @return el valor con mayor cantidad de repeticiones para la propiedad giveWay
   */
  @Query(
      "select atd.giveWay as value, count(atd) as count \n"
          + "from AccidentTerrainData atd \n"
          + "group by atd.giveWay \n"
          + "order by count(atd.giveWay) desc \n")
  List<ValueCount> findMostCommonGiveWay(Pageable pageable);

  /**
   * Retorna el valor con mayor cantidad de repeticiones para la propiedad junction
   *
   * @param pageable
   * @return el valor con mayor cantidad de repeticiones para la propiedad junction
   */
  @Query(
      "select atd.junction as value, count(atd) as count \n"
          + "from AccidentTerrainData atd \n"
          + "group by atd.junction \n"
          + "order by count(atd.junction) desc \n")
  List<ValueCount> findMostCommonJunction(Pageable pageable);

  /**
   * Retorna el valor con mayor cantidad de repeticiones para la propiedad noExit
   *
   * @param pageable
   * @return el valor con mayor cantidad de repeticiones para la propiedad noExit
   */
  @Query(
      "select atd.noExit as value, count(atd) as count \n"
          + "from AccidentTerrainData atd \n"
          + "group by atd.noExit \n"
          + "order by count(atd.noExit) desc \n")
  List<ValueCount> findMostCommonNoExit(Pageable pageable);

  /**
   * Retorna el valor con mayor cantidad de repeticiones para la propiedad railway
   *
   * @param pageable
   * @return el valor con mayor cantidad de repeticiones para la propiedad railway
   */
  @Query(
      "select atd.railway as value, count(atd) as count \n"
          + "from AccidentTerrainData atd \n"
          + "group by atd.railway \n"
          + "order by count(atd.railway) desc \n")
  List<ValueCount> findMostCommonRailway(Pageable pageable);

  /**
   * Retorna el valor con mayor cantidad de repeticiones para la propiedad stop
   *
   * @param pageable
   * @return el valor con mayor cantidad de repeticiones para la propiedad stop
   */
  @Query(
      "select atd.stop as value, count(atd) as count \n"
          + "from AccidentTerrainData atd \n"
          + "group by atd.stop \n"
          + "order by count(atd.stop) desc \n")
  List<ValueCount> findMostCommonStop(Pageable pageable);

  /**
   * Retorna el valor con mayor cantidad de repeticiones para la propiedad turningLoop
   *
   * @param pageable
   * @return el valor con mayor cantidad de repeticiones para la propiedad turningLoop
   */
  @Query(
      "select atd.turningLoop as value, count(atd) as count \n"
          + "from AccidentTerrainData atd \n"
          + "group by atd.turningLoop \n"
          + "order by count(atd.turningLoop) desc \n")
  List<ValueCount> findMostCommonTurningLoop(Pageable pageable);

  /**
   * Retorna el valor con mayor cantidad de repeticiones para la propiedad station
   *
   * @param pageable
   * @return el valor con mayor cantidad de repeticiones para la propiedad station
   */
  @Query(
      "select atd.station as value, count(atd) as count \n"
          + "from AccidentTerrainData atd \n"
          + "group by atd.station \n"
          + "order by count(atd.station) desc \n")
  List<ValueCount> findMostCommonStation(Pageable pageable);
}

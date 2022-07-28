package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.repository.jpa.projections.StreetStatistics;
import com.bbdd2promocion.repository.jpa.projections.ValueCount;
import org.springframework.data.domain.Pageable;
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
     * Retorna datos de las N (pageable) calles con mas accidentes
     *
     * @param pageable
     * @return datos (StreetStatistics) de las N (pageable) calles con mas accidentes
     */
    @Query("SELECT a.street as street, a.zipcode as zipcode, COUNT(a) as count FROM Accident a GROUP BY a.street, a.zipcode ORDER BY COUNT(a) DESC")
    List<StreetStatistics> getStreetsWithMostAccidents(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad weatherCondition
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad weatherCondition
     */
    @Query("select a.weatherCondition as value, count(a) as count \n" +
            "from Accident a \n" +
            "group by a.weatherCondition \n" +
            "order by count(a.weatherCondition) desc \n")
    List<ValueCount> findMostCommonWeatherCondition(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad visibility
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad visibility
     */
    @Query("select a.visibility as value, count(a) as count \n" +
            "from Accident a \n" +
            "group by a.visibility \n" +
            "order by count(a.visibility) desc\n")
    List<ValueCount> findMostCommonVisibility(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad windChill
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad windChill
     */
    @Query("select a.windChill as value, count(a) as count \n" +
            "from Accident a \n" +
            "group by a.windChill \n" +
            "order by count(a.windChill) desc \n")
    List<ValueCount> findMostCommonWindChill(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad windDirection
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad windDirection
     */
    @Query("select a.windDirection as value, count(a) as count \n" +
            "from Accident a \n" +
            "group by a.windDirection \n" +
            "order by count(a.windDirection) desc \n")
    List<ValueCount> findMostCommonWindDirection(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad windSpeed
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad windSpeed
     */
    @Query("select a.windSpeed as value, count(a) as count \n" +
            "from Accident a \n" +
            "group by a.windSpeed \n" +
            "order by count(a.windSpeed) desc \n")
    List<ValueCount> findMostCommonWindSpeed(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad pressure
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad pressure
     */
    @Query("select a.pressure as value, count(a) as count \n" +
            "from Accident a \n" +
            "group by a.pressure \n" +
            "order by count(a.pressure) desc \n")
    List<ValueCount> findMostCommonPressure(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad humidity
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad humidity
     */
    @Query("select a.humidity as value, count(a) as count \n" +
            "from Accident a \n" +
            "group by a.humidity \n" +
            "order by count(a.humidity) desc \n")
    List<ValueCount> findMostCommonHumidity(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad temperature
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad temperature
     */
    @Query("select a.temperature as value, count(a) as count \n" +
            "from Accident a \n" +
            "group by a.temperature \n" +
            "order by count(a.temperature) desc \n")
    List<ValueCount> findMostCommonTemperature(Pageable pageable);

}

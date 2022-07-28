package com.bbdd2promocion.repository.jpa;

import com.bbdd2promocion.model.AccidentWeatherData;
import com.bbdd2promocion.repository.jpa.projections.ValueCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAAccidentWeatherDataRepository extends JpaRepository<AccidentWeatherData, Long> {

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad
     * weatherCondition
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad
     *         weatherCondition
     */
    @Query("select awd.weatherCondition as value, count(awd) as count \n" +
            "from AccidentWeatherData awd \n" +
            "group by awd.weatherCondition \n" +
            "order by count(awd.weatherCondition) desc \n")
    List<ValueCount> findMostCommonWeatherCondition(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad
     * visibility
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad
     *         visibility
     */
    @Query("select awd.visibility as value, count(awd) as count \n" +
            "from AccidentWeatherData awd \n" +
            "group by awd.visibility \n" +
            "order by count(awd.visibility) desc\n")
    List<ValueCount> findMostCommonVisibility(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad
     * windChill
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad
     *         windChill
     */
    @Query("select awd.windChill as value, count(awd) as count \n" +
            "from AccidentWeatherData awd \n" +
            "group by awd.windChill \n" +
            "order by count(awd.windChill) desc \n")
    List<ValueCount> findMostCommonWindChill(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad
     * windDirection
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad
     *         windDirection
     */
    @Query("select awd.windDirection as value, count(awd) as count \n" +
            "from AccidentWeatherData awd \n" +
            "group by awd.windDirection \n" +
            "order by count(awd.windDirection) desc \n")
    List<ValueCount> findMostCommonWindDirection(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad
     * windSpeed
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad
     *         windSpeed
     */
    @Query("select awd.windSpeed as value, count(awd) as count \n" +
            "from AccidentWeatherData awd \n" +
            "group by awd.windSpeed \n" +
            "order by count(awd.windSpeed) desc \n")
    List<ValueCount> findMostCommonWindSpeed(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad
     * pressure
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad
     *         pressure
     */
    @Query("select awd.pressure as value, count(awd) as count \n" +
            "from AccidentWeatherData awd \n" +
            "group by awd.pressure \n" +
            "order by count(awd.pressure) desc \n")
    List<ValueCount> findMostCommonPressure(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad
     * humidity
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad
     *         humidity
     */
    @Query("select awd.humidity as value, count(awd) as count \n" +
            "from AccidentWeatherData awd \n" +
            "group by awd.humidity \n" +
            "order by count(awd.humidity) desc \n")
    List<ValueCount> findMostCommonHumidity(Pageable pageable);

    /**
     * Retorna el valor con mayor cantidad de repeticiones para la propiedad
     * temperature
     *
     * @param pageable
     * @return el valor con mayor cantidad de repeticiones para la propiedad
     *         temperature
     */
    @Query("select awd.temperature as value, count(awd) as count \n" +
            "from AccidentWeatherData awd \n" +
            "group by awd.temperature \n" +
            "order by count(awd.temperature) desc \n")
    List<ValueCount> findMostCommonTemperature(Pageable pageable);

}

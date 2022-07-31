/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.bbdd2promocion.service.impl;

import com.bbdd2promocion.helpers.ConditionValues;
import com.bbdd2promocion.model.Accident;
import com.bbdd2promocion.repository.jpa.JPAAccidentRepository;
import com.bbdd2promocion.repository.jpa.projections.StreetStatistics;
import com.bbdd2promocion.repository.mongo.projections.HourCount;
import com.bbdd2promocion.repository.mongo.projections.LocationCount;
import com.bbdd2promocion.repository.mongo.MongoAccidentRepository;
import com.bbdd2promocion.repository.jpa.projections.ValueCount;
import com.bbdd2promocion.service.IAccidentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Circle;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * Accident.
 */
@Service
@Transactional
public class AccidentServiceImpl implements IAccidentService {

    /**
     * Es el repositorio ligado a los Accident
     */

    @Inject
    private MongoAccidentRepository accidentMongoRepository;

    @Inject
    private JPAAccidentRepository jpaAccidentRepository;

    @Override
    public List<Accident> findByStartLocationWithinRadius(Circle circle) {
        return this.getAccidentMongoRepository().findByStartLocationWithin(circle);
    }

    @Override
    public Double getAverageDistance() {
        return this.getAccidentJPARepository().getAverageDistance();
    }

    @Override
    public List<Accident> findBetweenDates(Date startDate, Date endDate) {
        return this.getAccidentJPARepository().findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(startDate,
                endDate);
    }

    @Override
    public List<StreetStatistics> getStreetsWithMostAccidents(int limit) {
        return this.getAccidentJPARepository().getStreetsWithMostAccidents(PageRequest.of(0, limit));
    }

    @Override
    public List<LocationCount> getMostDangerousPointsWithinRadius(Double longitude, Double latitude, Double radius,
            int limit) {
        return this.getAccidentMongoRepository().findMostDangerousPointsWithinRadius(longitude, latitude, radius, limit)
                .getMappedResults();
    }

    @Override
    public List<ConditionValues> getMostCommonWeatherConditions() {
        PageRequest pageRequest = PageRequest.of(0, 1);

        ValueCount weatherConditionCount = this.getAccidentJPARepository().findMostCommonWeatherCondition(pageRequest)
                .get(0);
        ValueCount pressureCount = this.getAccidentJPARepository().findMostCommonPressure(pageRequest).get(0);
        ValueCount humidityCount = this.getAccidentJPARepository().findMostCommonHumidity(pageRequest).get(0);
        ValueCount temperatureCount = this.getAccidentJPARepository().findMostCommonTemperature(pageRequest).get(0);
        ValueCount visibilityCount = this.getAccidentJPARepository().findMostCommonVisibility(pageRequest).get(0);
        ValueCount windChillCount = this.getAccidentJPARepository().findMostCommonWindChill(pageRequest).get(0);
        ValueCount windDirectionCount = this.getAccidentJPARepository().findMostCommonWindDirection(pageRequest).get(0);
        ValueCount windSpeedCount = this.getAccidentJPARepository().findMostCommonWindSpeed(pageRequest).get(0);

        List<ConditionValues> weatherConditions = new ArrayList<>();
        weatherConditions.add(new ConditionValues("Weather Condition", weatherConditionCount));
        weatherConditions.add(new ConditionValues("Temperature(F)", temperatureCount));
        weatherConditions.add(new ConditionValues("Pressure(in)", pressureCount));
        weatherConditions.add(new ConditionValues("Humidity(%)", humidityCount));
        weatherConditions.add(new ConditionValues("Visibility(mi)", visibilityCount));
        weatherConditions.add(new ConditionValues("Wind Chill(F)", windChillCount));
        weatherConditions.add(new ConditionValues("Wind Speed(mph)", windSpeedCount));
        weatherConditions.add(new ConditionValues("Wind Direction", windDirectionCount));
        return weatherConditions;
    }

    @Override
    public HourCount getMostCommonHourConditions() {
        return this.getAccidentMongoRepository().findMostCommonHour().getMappedResults().get(0);
    }

    /**
     * Getter.
     *
     * @return el repositorio de Accident (MongoDB).
     */
    public MongoAccidentRepository getAccidentMongoRepository() {
        return this.accidentMongoRepository;
    }

    /**
     * Getter.
     *
     * @return el repositorio de Accident (JPA).
     */
    public JPAAccidentRepository getAccidentJPARepository() {
        return this.jpaAccidentRepository;
    }

    @Override
    public List<ConditionValues> getMostCommonTerrainConditions() {
        PageRequest pageRequest = PageRequest.of(0, 1);

        ValueCount crossingCount = this.getAccidentJPARepository().findMostCommonCrossing(pageRequest).get(0);
        ValueCount giveWayCount = this.getAccidentJPARepository().findMostCommonGiveWay(pageRequest).get(0);
        ValueCount junctionCount = this.getAccidentJPARepository().findMostCommonJunction(pageRequest).get(0);
        ValueCount noExitCount = this.getAccidentJPARepository().findMostCommonNoExit(pageRequest).get(0);
        ValueCount railwayCount = this.getAccidentJPARepository().findMostCommonRailway(pageRequest).get(0);
        ValueCount stopCount = this.getAccidentJPARepository().findMostCommonStop(pageRequest).get(0);
        ValueCount turningLoopCount = this.getAccidentJPARepository().findMostCommonTurningLoop(pageRequest).get(0);
        ValueCount stationCount = this.getAccidentJPARepository().findMostCommonStation(pageRequest).get(0);

        List<ConditionValues> terrainConditions = new ArrayList<>();

        terrainConditions.add(new ConditionValues("Crossing", crossingCount));
        terrainConditions.add(new ConditionValues("Give Way", giveWayCount));
        terrainConditions.add(new ConditionValues("Junction", junctionCount));
        terrainConditions.add(new ConditionValues("No Exit", noExitCount));
        terrainConditions.add(new ConditionValues("Railway", railwayCount));
        terrainConditions.add(new ConditionValues("Stop", stopCount));
        terrainConditions.add(new ConditionValues("Turning Loop", turningLoopCount));
        terrainConditions.add(new ConditionValues("Station", stationCount));
        return terrainConditions;
    }
}

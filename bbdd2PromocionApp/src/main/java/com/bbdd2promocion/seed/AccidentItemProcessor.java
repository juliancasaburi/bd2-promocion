package com.bbdd2promocion.seed;

import com.bbdd2promocion.dto.AccidentDTO;
import com.bbdd2promocion.model.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class AccidentItemProcessor implements ItemProcessor<AccidentDTO, Accident> {

    @Override
    public Accident process(AccidentDTO data) throws Exception {

        AccidentLocationData accidentLocationData = new AccidentLocationData();
        accidentLocationData.setStartLocation(new GeoJsonPoint(Double.parseDouble(data.getStartLng()), Double.parseDouble(data.getStartLat())));
        accidentLocationData.setStartLat(data.getStartLat());
        accidentLocationData.setStartLng(data.getStartLng());
        accidentLocationData.setEndLat(data.getEndLat());
        accidentLocationData.setEndLng(data.getEndLng());
        accidentLocationData.setNumber(data.getNumber());
        accidentLocationData.setStreet(data.getStreet());
        accidentLocationData.setSide(data.getSide());
        accidentLocationData.setCountry(data.getCountry());
        accidentLocationData.setCounty(data.getCounty());
        accidentLocationData.setState(data.getState());
        accidentLocationData.setZipcode(data.getZipcode());
        accidentLocationData.setCity(data.getCity());
        accidentLocationData.setAirportCode(data.getAirportCode());
        accidentLocationData.setTimezone(data.getTimezone());

        AccidentWeatherData accidentWeatherData = new AccidentWeatherData();
        accidentWeatherData.setWeatherTimestamp(data.getWeatherTimestamp());
        accidentWeatherData.setWeatherCondition(data.getWeatherCondition());
        accidentWeatherData.setHumidity(data.getHumidity());
        accidentWeatherData.setPressure(data.getPressure());
        accidentWeatherData.setTemperature(data.getTemperature());
        accidentWeatherData.setPrecipitation(data.getPrecipitation());
        accidentWeatherData.setVisibility(data.getVisibility());
        accidentWeatherData.setWindChill(data.getWindChill());
        accidentWeatherData.setWindDirection(data.getWindDirection());
        accidentWeatherData.setWindSpeed(data.getWindSpeed());

        AccidentTerrainData accidentTerrainData = new AccidentTerrainData();
        accidentTerrainData.setAmenity(data.getAmenity());
        accidentTerrainData.setBump(data.getBump());
        accidentTerrainData.setGiveWay(data.getGiveWay());
        accidentTerrainData.setJunction(data.getJunction());
        accidentTerrainData.setCrossing(data.getCrossing());
        accidentTerrainData.setRailway(data.getRailway());
        accidentTerrainData.setRoundabout(data.getRoundabout());
        accidentTerrainData.setNoExit(data.getNoExit());
        accidentTerrainData.setStation(data.getStation());
        accidentTerrainData.setStop(data.getStop());
        accidentTerrainData.setTrafficCalming(data.getTrafficCalming());
        accidentTerrainData.setTrafficSignal(data.getTrafficSignal());
        accidentTerrainData.setTurningLoop(data.getTurningLoop());


        Accident accident = new Accident();

        accident.setAccidentLocationData(accidentLocationData);
        accident.setAccidentWeatherData(accidentWeatherData);
        accident.setAccidentTerrainData(accidentTerrainData);

        accident.setCsvId(data.getCsvId());
        accident.setDescription(data.getDescription());
        accident.setSource(data.getSource());
        accident.setTmc(data.getTmc());
        accident.setSeverity(data.getSeverity());
        accident.setStartTime(data.getStartTime());
        accident.setEndTime(data.getEndTime());
        accident.setDistance(data.getDistance());
        accident.setSunriseSunset(data.getSunriseSunset());
        accident.setCivilTwilight(data.getCivilTwilight());
        accident.setNauticalTwilight(data.getNauticalTwilight());
        accident.setAstronomicalTwilight(data.getAstronomicalTwilight());

        return accident;
    }

}

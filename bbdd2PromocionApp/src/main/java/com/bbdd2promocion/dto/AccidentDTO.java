package com.bbdd2promocion.dto;

import java.util.Date;

public class AccidentDTO {

  private String csvId;

  private String source;

  private String tmc;

  private Double severity;

  private Date startTime;

  private Date endTime;

  private String startLat;

  private String startLng;

  private String endLat;

  private String endLng;

  private Double distance;

  private String description;

  private String number;

  private String street;

  private String side;

  private String city;

  private String county;

  private String state;

  private String zipcode;

  private String country;

  private String timezone;

  private String airportCode;

  private String weatherTimestamp;

  private Double temperature;

  private Double windChill;

  private Double humidity;

  private Double pressure;

  private Double visibility;

  private String windDirection;

  private Double windSpeed;

  private Double precipitation;

  private String weatherCondition;

  private Boolean amenity;

  private Boolean bump;

  private Boolean crossing;

  private Boolean giveWay;

  private Boolean junction;

  private Boolean noExit;

  private Boolean railway;

  private Boolean roundabout;

  private Boolean station;

  private Boolean stop;

  private Boolean trafficCalming;

  private Boolean trafficSignal;

  private Boolean turningLoop;

  private String sunriseSunset;

  private String civilTwilight;

  private String nauticalTwilight;

  private String astronomicalTwilight;

  public AccidentDTO() {}

  public AccidentDTO(
      String csvId,
      String source,
      String tmc,
      Double severity,
      Date startTime,
      Date endTime,
      String startLat,
      String startLng,
      String endLat,
      String endLng,
      Double distance,
      String description,
      String number,
      String street,
      String side,
      String city,
      String county,
      String state,
      String zipcode,
      String country,
      String timezone,
      String airportCode,
      String weatherTimestamp,
      Double temperature,
      Double windChill,
      Double humidity,
      Double pressure,
      Double visibility,
      String windDirection,
      Double windSpeed,
      Double precipitation,
      String weatherCondition,
      Boolean amenity,
      Boolean bump,
      Boolean crossing,
      Boolean giveWay,
      Boolean junction,
      Boolean noExit,
      Boolean railway,
      Boolean roundabout,
      Boolean station,
      Boolean stop,
      Boolean trafficCalming,
      Boolean trafficSignal,
      Boolean turningLoop,
      String sunriseSunset,
      String civilTwilight,
      String nauticalTwilight,
      String astronomicalTwilight) {
    this.csvId = csvId;
    this.source = source;
    this.tmc = tmc;
    this.severity = severity;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startLat = startLat;
    this.startLng = startLng;
    this.endLat = endLat;
    this.endLng = endLng;
    this.distance = distance;
    this.description = description;
    this.number = number;
    this.street = street;
    this.side = side;
    this.city = city;
    this.county = county;
    this.state = state;
    this.zipcode = zipcode;
    this.country = country;
    this.timezone = timezone;
    this.airportCode = airportCode;
    this.weatherTimestamp = weatherTimestamp;
    this.temperature = temperature;
    this.windChill = windChill;
    this.humidity = humidity;
    this.pressure = pressure;
    this.visibility = visibility;
    this.windDirection = windDirection;
    this.windSpeed = windSpeed;
    this.precipitation = precipitation;
    this.weatherCondition = weatherCondition;
    this.amenity = amenity;
    this.bump = bump;
    this.crossing = crossing;
    this.giveWay = giveWay;
    this.junction = junction;
    this.noExit = noExit;
    this.railway = railway;
    this.roundabout = roundabout;
    this.station = station;
    this.stop = stop;
    this.trafficCalming = trafficCalming;
    this.trafficSignal = trafficSignal;
    this.turningLoop = turningLoop;
    this.sunriseSunset = sunriseSunset;
    this.civilTwilight = civilTwilight;
    this.nauticalTwilight = nauticalTwilight;
    this.astronomicalTwilight = astronomicalTwilight;
  }

  public void setCsvId(String csvId) {
    this.csvId = csvId;
  }

  public String getCsvId() {
    return csvId;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTmc() {
    return tmc;
  }

  public void setTmc(String tmc) {
    this.tmc = tmc;
  }

  public Double getSeverity() {
    return severity;
  }

  public void setSeverity(Double severity) {
    this.severity = severity;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getStartLat() {
    return startLat;
  }

  public void setStartLat(String startLat) {
    this.startLat = startLat;
  }

  public String getStartLng() {
    return startLng;
  }

  public void setStartLng(String startLng) {
    this.startLng = startLng;
  }

  public String getEndLat() {
    return endLat;
  }

  public void setEndLat(String endLat) {
    this.endLat = endLat;
  }

  public String getEndLng() {
    return endLng;
  }

  public void setEndLng(String endLng) {
    this.endLng = endLng;
  }

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getSide() {
    return side;
  }

  public void setSide(String side) {
    this.side = side;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getAirportCode() {
    return airportCode;
  }

  public void setAirportCode(String airportCode) {
    this.airportCode = airportCode;
  }

  public String getWeatherTimestamp() {
    return weatherTimestamp;
  }

  public void setWeatherTimestamp(String weatherTimestamp) {
    this.weatherTimestamp = weatherTimestamp;
  }

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public Double getWindChill() {
    return windChill;
  }

  public void setWindChill(Double windChill) {
    this.windChill = windChill;
  }

  public Double getHumidity() {
    return humidity;
  }

  public void setHumidity(Double humidity) {
    this.humidity = humidity;
  }

  public Double getPressure() {
    return pressure;
  }

  public void setPressure(Double pressure) {
    this.pressure = pressure;
  }

  public Double getVisibility() {
    return visibility;
  }

  public void setVisibility(Double visibility) {
    this.visibility = visibility;
  }

  public String getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(String windDirection) {
    this.windDirection = windDirection;
  }

  public Double getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(Double windSpeed) {
    this.windSpeed = windSpeed;
  }

  public Double getPrecipitation() {
    return precipitation;
  }

  public void setPrecipitation(Double precipitation) {
    this.precipitation = precipitation;
  }

  public String getWeatherCondition() {
    return weatherCondition;
  }

  public void setWeatherCondition(String weatherCondition) {
    this.weatherCondition = weatherCondition;
  }

  public Boolean getAmenity() {
    return amenity;
  }

  public void setAmenity(Boolean amenity) {
    this.amenity = amenity;
  }

  public Boolean getBump() {
    return bump;
  }

  public void setBump(Boolean bump) {
    this.bump = bump;
  }

  public Boolean getCrossing() {
    return crossing;
  }

  public void setCrossing(Boolean crossing) {
    this.crossing = crossing;
  }

  public Boolean getGiveWay() {
    return giveWay;
  }

  public void setGiveWay(Boolean giveWay) {
    this.giveWay = giveWay;
  }

  public Boolean getJunction() {
    return junction;
  }

  public void setJunction(Boolean junction) {
    this.junction = junction;
  }

  public Boolean getNoExit() {
    return noExit;
  }

  public void setNoexit(Boolean noexit) {
    this.noExit = noexit;
  }

  public Boolean getRailway() {
    return railway;
  }

  public void setRailway(Boolean railway) {
    this.railway = railway;
  }

  public Boolean getRoundabout() {
    return roundabout;
  }

  public void setRoundabout(Boolean roundabout) {
    this.roundabout = roundabout;
  }

  public Boolean getStation() {
    return station;
  }

  public void setStation(Boolean station) {
    this.station = station;
  }

  public Boolean getStop() {
    return stop;
  }

  public void setStop(Boolean stop) {
    this.stop = stop;
  }

  public Boolean getTrafficCalming() {
    return trafficCalming;
  }

  public void setTrafficCalming(Boolean trafficCalming) {
    this.trafficCalming = trafficCalming;
  }

  public Boolean getTrafficSignal() {
    return trafficSignal;
  }

  public void setTrafficSignal(Boolean trafficSignal) {
    this.trafficSignal = trafficSignal;
  }

  public Boolean getTurningLoop() {
    return turningLoop;
  }

  public void setTurningLoop(Boolean turningLoop) {
    this.turningLoop = turningLoop;
  }

  public String getSunriseSunset() {
    return sunriseSunset;
  }

  public void setSunriseSunset(String sunriseSunset) {
    this.sunriseSunset = sunriseSunset;
  }

  public String getCivilTwilight() {
    return civilTwilight;
  }

  public void setCivilTwilight(String civilTwilight) {
    this.civilTwilight = civilTwilight;
  }

  public String getNauticalTwilight() {
    return nauticalTwilight;
  }

  public void setNauticalTwilight(String nauticalTwilight) {
    this.nauticalTwilight = nauticalTwilight;
  }

  public String getAstronomicalTwilight() {
    return astronomicalTwilight;
  }

  public void setAstronomicalTwilight(String astronomicalTwilight) {
    this.astronomicalTwilight = astronomicalTwilight;
  }

  @Override
  public String toString() {
    return "Accident{"
        + "id='"
        + csvId
        + '\''
        + ", source='"
        + source
        + '\''
        + ", tmc='"
        + tmc
        + '\''
        + ", severity="
        + severity
        + ", startTime="
        + startTime
        + ", endTime="
        + endTime
        + ", startLat='"
        + startLat
        + '\''
        + ", startLng='"
        + startLng
        + '\''
        + ", endLat='"
        + endLat
        + '\''
        + ", endLng='"
        + endLng
        + '\''
        + ", distance="
        + distance
        + ", description='"
        + description
        + '\''
        + ", number='"
        + number
        + '\''
        + ", street='"
        + street
        + '\''
        + ", side='"
        + side
        + '\''
        + ", city='"
        + city
        + '\''
        + ", county='"
        + county
        + '\''
        + ", state='"
        + state
        + '\''
        + ", zipcode='"
        + zipcode
        + '\''
        + ", country='"
        + country
        + '\''
        + ", timezone='"
        + timezone
        + '\''
        + ", airportCode='"
        + airportCode
        + '\''
        + ", weatherTimestamp="
        + weatherTimestamp
        + ", temperature="
        + temperature
        + ", windChill="
        + windChill
        + ", humidity="
        + humidity
        + ", pressure="
        + pressure
        + ", visibility="
        + visibility
        + ", windDirection='"
        + windDirection
        + '\''
        + ", windSpeed="
        + windSpeed
        + ", precipitation="
        + precipitation
        + ", weatherCondition='"
        + weatherCondition
        + '\''
        + ", amenity="
        + amenity
        + ", bump="
        + bump
        + ", crossing="
        + crossing
        + ", giveWay="
        + giveWay
        + ", junction="
        + junction
        + ", noExit="
        + noExit
        + ", railway="
        + railway
        + ", roundabout="
        + roundabout
        + ", station="
        + station
        + ", stop="
        + stop
        + ", trafficCalming="
        + trafficCalming
        + ", trafficSignal="
        + trafficSignal
        + ", turningLoop="
        + turningLoop
        + ", sunriseSunset='"
        + sunriseSunset
        + '\''
        + ", civilTwilight='"
        + civilTwilight
        + '\''
        + ", NauticalTwilight='"
        + nauticalTwilight
        + '\''
        + ", AstronomicalTwilight='"
        + astronomicalTwilight
        + '\''
        + '}';
  }
}

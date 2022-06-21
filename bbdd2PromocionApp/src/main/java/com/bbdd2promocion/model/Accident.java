package com.bbdd2promocion.model;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "Accidents")
public class Accident {

	@Field(name = "ID")
	private String id;

	@Field(name = "source")
	private String source;

	@Field(name = "tmc")
	private String tmc;

	@Field(name = "severity")
	private Double severity;

	@Field(name = "startTime")
	private Date startTime;

	@Field(name = "endTime")
	private Date endTime;

	@Field(name = "startLat")
	private String startLat;

	@Field(name = "startLng")
	private String startLng;

	/**
	 * startLocation is stored in GeoJSON format.
	 * {
	 *   "type" : "Point",
	 *   "coordinates" : [ x, y ]
	 * }
	 */
	@Field(name = "startLocation")
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint startLocation;

	@Field(name = "endLat")
	private String endLat;

	@Field(name = "endLng")
	private String endLng;

	@Field(name = "distance")
	private Double distance;

	@Field(name = "description")
	private String description;

	@Field(name = "number")
	private String number;

	@Field(name = "street")
	private String street;

	@Field(name = "side")
	private String side;

	@Field(name = "city")
	private String city;

	@Field(name = "county")
	private String county;

	@Field(name = "state")
	private String state;

	@Field(name = "zipcode")
	private String zipcode;

	@Field(name = "country")
	private String country;

	@Field(name = "timezone")
	private String timezone;

	@Field(name = "airportCode")
	private String airportCode;

	@Field(name = "weatherTimestamp")
	private String weatherTimestamp;

	@Field(name = "Temperature(F)")
	private Double temperature;

	@Field(name = "Wind_Chill(F)")
	private Double windChill;

	@Field(name = "Humidity(%)")
	private Double humidity;

	@Field(name = "Pressure(in)")
	private Double pressure;

	@Field(name = "Visibility(mi)")
	private Double visibility;

	@Field(name = "windDirection")
	private String windDirection;

	@Field(name = "windSpeed")
	private Double windSpeed;

	@Field(name = "Precipitation(in)")
	private Double precipitation;

	@Field(name = "weatherCondition")
	private String weatherCondition;

	@Field(name = "amenity")
	private Boolean amenity;

	@Field(name = "bump")
	private Boolean bump;

	@Field(name = "crossing")
	private Boolean crossing;

	@Field(name = "giveWay")
	private Boolean giveWay;

	@Field(name = "junction")
	private Boolean junction;

	@Field(name = "noExit")
	private Boolean noExit;

	@Field(name = "railway")
	private Boolean railway;

	@Field(name = "roundabout")
	private Boolean roundabout;

	@Field(name = "station")
	private Boolean station;

	@Field(name = "stop")
	private Boolean stop;

	@Field(name = "trafficCalming")
	private Boolean trafficCalming;

	@Field(name = "trafficSignal")
	private Boolean trafficSignal;

	@Field(name = "turningLoop")
	private Boolean turningLoop;

	@Field(name = "sunriseSunset")
	private String sunriseSunset;

	@Field(name = "civilTwilight")
	private String civilTwilight;

	@Field(name = "nauticalTwilight")
	private String nauticalTwilight;

	@Field(name = "astronomicalTwilight")
	private String astronomicalTwilight;

	public Accident() {

	}

	public Accident(String id, String source, String tmc, Double severity, Date startTime, Date endTime, String startLat, String startLng, String endLat, String endLng, Double distance, String description, String number, String street, String side, String city, String county, String state, String zipcode, String country, String timezone, String airportCode, String weatherTimestamp, Double temperature, Double windChill, Double humidity, Double pressure, Double visibility, String windDirection, Double windSpeed, Double precipitation, String weatherCondition, Boolean amenity, Boolean bump, Boolean crossing, Boolean giveWay, Boolean junction, Boolean noExit, Boolean railway, Boolean roundabout, Boolean station, Boolean stop, Boolean trafficCalming, Boolean trafficSignal, Boolean turningLoop, String sunriseSunset, String civilTwilight, String nauticalTwilight, String astronomicalTwilight) {
		this.id = id;
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

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
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

	public GeoJsonPoint getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(GeoJsonPoint point) {
		this.startLocation = point;
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
		return "Accident{" +
				"id='" + id + '\'' +
				", source='" + source + '\'' +
				", tmc='" + tmc + '\'' +
				", severity=" + severity +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", startLat='" + startLat + '\'' +
				", startLng='" + startLng + '\'' +
				", startLocation='" + startLocation + '\'' +
				", endLat='" + endLat + '\'' +
				", endLng='" + endLng + '\'' +
				", distance=" + distance +
				", description='" + description + '\'' +
				", number='" + number + '\'' +
				", street='" + street + '\'' +
				", side='" + side + '\'' +
				", city='" + city + '\'' +
				", county='" + county + '\'' +
				", state='" + state + '\'' +
				", zipcode='" + zipcode + '\'' +
				", country='" + country + '\'' +
				", timezone='" + timezone + '\'' +
				", airportCode='" + airportCode + '\'' +
				", weatherTimestamp=" + weatherTimestamp +
				", temperature=" + temperature +
				", windChill=" + windChill +
				", humidity=" + humidity +
				", pressure=" + pressure +
				", visibility=" + visibility +
				", windDirection='" + windDirection + '\'' +
				", windSpeed=" + windSpeed +
				", precipitation=" + precipitation +
				", weatherCondition='" + weatherCondition + '\'' +
				", amenity=" + amenity +
				", bump=" + bump +
				", crossing=" + crossing +
				", giveWay=" + giveWay +
				", junction=" + junction +
				", noExit=" + noExit +
				", railway=" + railway +
				", roundabout=" + roundabout +
				", station=" + station +
				", stop=" + stop +
				", trafficCalming=" + trafficCalming +
				", trafficSignal=" + trafficSignal +
				", turningLoop=" + turningLoop +
				", sunriseSunset='" + sunriseSunset + '\'' +
				", civilTwilight='" + civilTwilight + '\'' +
				", NauticalTwilight='" + nauticalTwilight + '\'' +
				", AstronomicalTwilight='" + astronomicalTwilight + '\'' +
				'}';
	}
}

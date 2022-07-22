package com.bbdd2promocion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;
import java.util.Date;

@Document(collection = "Accidents")
@Entity
@Table(name = "accidents")
public class Accident {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@BsonIgnore
	@JsonIgnore
	private Long id;

	@MongoId
	@Transient
	@JsonIgnore
	private String mongoId;

	@Field(name = "csvId")
	@Column(name = "csv_id")
	private String csvId;

	@Field(name = "source")
	@Column(name = "source")
	private String source;

	@Field(name = "tmc")
	@Column(name = "tmc")
	private String tmc;

	@Field(name = "severity")
	@Column(name = "severity")
	private Double severity;

	@Field(name = "startTime")
	@Column(name = "start_time")
	private Date startTime;

	@Field(name = "endTime")
	@Column(name = "end_time")
	private Date endTime;

	@Field(name = "startLat")
	@Column(name = "start_lat")
	private String startLat;

	@Field(name = "startLng")
	@Column(name = "start_lng")
	private String startLng;

	/**
	 * startLocation is stored in GeoJSON format.
	 * {
	 *   "type" : "Point",
	 *   "coordinates" : [ x, y ]
	 * }
	 */
	@Field(name = "startLocation")
	@Column(name = "start_location")
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	@Transient
	@JsonIgnore
	private GeoJsonPoint startLocation;

	@Field(name = "endLat")
	@Column(name = "end_lat")
	private String endLat;

	@Field(name = "endLng")
	@Column(name = "end_lng")
	private String endLng;

	@Field(name = "distance")
	@Column(name = "distance")
	private Double distance;

	@Field(name = "description")
	@Column(name = "description", columnDefinition="TEXT")
	private String description;

	@Field(name = "number")
	@Column(name = "number")
	private String number;

	@Field(name = "street")
	@Column(name = "street")
	private String street;

	@Field(name = "side")
	@Column(name = "side")
	private String side;

	@Field(name = "city")
	@Column(name = "city")
	private String city;

	@Field(name = "county")
	@Column(name = "county")
	private String county;

	@Field(name = "state")
	@Column(name = "state")
	private String state;

	@Field(name = "zipcode")
	@Column(name = "zipcode")
	private String zipcode;

	@Field(name = "country")
	@Column(name = "country")
	private String country;

	@Field(name = "timezone")
	@Column(name = "timezone")
	private String timezone;

	@Field(name = "airportCode")
	@Column(name = "airport_code")
	private String airportCode;

	@Field(name = "weatherTimestamp")
	@Column(name = "weather_timestamp")
	private String weatherTimestamp;

	@Field(name = "Temperature(F)")
	@Column(name = "temperature")
	private Double temperature;

	@Field(name = "Wind_Chill(F)")
	@Column(name = "wind_chill")
	private Double windChill;

	@Field(name = "Humidity(%)")
	@Column(name = "humidity")
	private Double humidity;

	@Field(name = "Pressure(in)")
	@Column(name = "pressure")
	private Double pressure;

	@Field(name = "Visibility(mi)")
	@Column(name = "visibility")
	private Double visibility;

	@Field(name = "windDirection")
	@Column(name = "wind_direction")
	private String windDirection;

	@Field(name = "windSpeed")
	@Column(name = "wind_speed")
	private Double windSpeed;

	@Field(name = "Precipitation(in)")
	@Column(name = "precipitation")
	private Double precipitation;

	@Field(name = "weatherCondition")
	@Column(name = "weather_condition")
	private String weatherCondition;

	@Field(name = "amenity")
	@Column(name = "amenity")
	private Boolean amenity;

	@Field(name = "bump")
	@Column(name = "bump")
	private Boolean bump;

	@Field(name = "crossing")
	@Column(name = "crossing")
	private Boolean crossing;

	@Field(name = "giveWay")
	@Column(name = "give_way")
	private Boolean giveWay;

	@Field(name = "junction")
	@Column(name = "junction")
	private Boolean junction;

	@Field(name = "noExit")
	@Column(name = "no_exit")
	private Boolean noExit;

	@Field(name = "railway")
	@Column(name = "railway")
	private Boolean railway;

	@Field(name = "roundabout")
	@Column(name = "round_about")
	private Boolean roundabout;

	@Field(name = "station")
	@Column(name = "station")
	private Boolean station;

	@Field(name = "stop")
	@Column(name = "stop")
	private Boolean stop;

	@Field(name = "trafficCalming")
	@Column(name = "traffic_calming")
	private Boolean trafficCalming;

	@Field(name = "trafficSignal")
	@Column(name = "traffic_signal")
	private Boolean trafficSignal;

	@Field(name = "turningLoop")
	@Column(name = "turning_loop")
	private Boolean turningLoop;

	@Field(name = "sunriseSunset")
	@Column(name = "sunrise_sunset")
	private String sunriseSunset;

	@Field(name = "civilTwilight")
	@Column(name = "civil_twilight")
	private String civilTwilight;

	@Field(name = "nauticalTwilight")
	@Column(name = "nautical_twilight")
	private String nauticalTwilight;

	@Field(name = "astronomicalTwilight")
	@Column(name = "astronomical_twilight")
	private String astronomicalTwilight;

	public Accident() {

	}

	public Accident(String csvId, String source, String tmc, Double severity, Date startTime, Date endTime, String startLat, String startLng, String endLat, String endLng, Double distance, String description, String number, String street, String side, String city, String county, String state, String zipcode, String country, String timezone, String airportCode, String weatherTimestamp, Double temperature, Double windChill, Double humidity, Double pressure, Double visibility, String windDirection, Double windSpeed, Double precipitation, String weatherCondition, Boolean amenity, Boolean bump, Boolean crossing, Boolean giveWay, Boolean junction, Boolean noExit, Boolean railway, Boolean roundabout, Boolean station, Boolean stop, Boolean trafficCalming, Boolean trafficSignal, Boolean turningLoop, String sunriseSunset, String civilTwilight, String nauticalTwilight, String astronomicalTwilight) {
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

	public Long getId() {
		return id;
	}

	public String getMongoId() {
		return mongoId;
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
				"id='" + csvId + '\'' +
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

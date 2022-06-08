package com.bbdd2promocion.model.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import javax.persistence.Id;
import java.sql.Timestamp;

@Document(collection = "Accidents")
public class Accident {

	@Field(name = "ID")
	private String id;

	@Field(name = "Source")
	private String source;

	@Field(name = "TMC")
	private String tmc;

	@Field(name = "Severity")
	private Double severity;

	@Field(name = "Start_Time")
	private Timestamp startTime;

	@Field(name = "End_Time")
	private Timestamp endTime;

	@Field(name = "Start_Lat")
	private String startLat;

	@Field(name = "Start_Lng")
	private String startLng;

	@Field(name = "End_Lat")
	private String endLat;

	@Field(name = "End_Lng")
	private String endLng;

	@Field(name = "Distance")
	private Double distance;

	@Field(name = "Description")
	private String description;

	@Field(name = "Number")
	private String number;

	@Field(name = "Street")
	private String street;

	@Field(name = "Side")
	private String side;

	@Field(name = "City")
	private String city;

	@Field(name = "County")
	private String county;

	@Field(name = "State")
	private String state;

	@Field(name = "Zipcode")
	private String zipcode;

	@Field(name = "Country")
	private String country;

	@Field(name = "Timezone")
	private String timezone;

	@Field(name = "Airport_Code")
	private String airportCode;

	@Field(name = "Weather_Timestamp")
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

	@Field(name = "Wind_Direction")
	private String windDirection;

	@Field(name = "Wind_Speed")
	private Double windSpeed;

	@Field(name = "Precipitation(in)")
	private Double precipitation;

	@Field(name = "Weather_Condition")
	private String weatherCondition;

	@Field(name = "Amenity")
	private Boolean amenity;

	@Field(name = "Bump")
	private Boolean bump;

	@Field(name = "Crossing")
	private Boolean crossing;

	@Field(name = "Give_Way")
	private Boolean giveWay;

	@Field(name = "Junction")
	private Boolean junction;

	@Field(name = "No_Exit")
	private Boolean noExit;

	@Field(name = "Railway")
	private Boolean railway;

	@Field(name = "Roundabout")
	private Boolean roundabout;

	@Field(name = "Station")
	private Boolean station;

	@Field(name = "Stop")
	private Boolean stop;

	@Field(name = "Traffic_Calming")
	private Boolean trafficCalming;

	@Field(name = "Traffic_Signal")
	private Boolean trafficSignal;

	@Field(name = "Turning_Loop")
	private Boolean turningLoop;

	@Field(name = "Sunrise_Sunset")
	private String sunriseSunset;

	@Field(name = "Civil_Twilight")
	private String civilTwilight;

	@Field(name = "Nautical_Twilight")
	private String NauticalTwilight;

	@Field(name = "Astronomical_Twilight")
	private String AstronomicalTwilight;

	public Accident() {

	}

	public Accident(String id, String source, String tmc, Double severity, Timestamp startTime, Timestamp endTime, String startLat, String startLng, String endLat, String endLng, Double distance, String description, String number, String street, String side, String city, String county, String state, String zipcode, String country, String timezone, String airportCode, String weatherTimestamp, Double temperature, Double windChill, Double humidity, Double pressure, Double visibility, String windDirection, Double windSpeed, Double precipitation, String weatherCondition, Boolean amenity, Boolean bump, Boolean crossing, Boolean giveWay, Boolean junction, Boolean noExit, Boolean railway, Boolean roundabout, Boolean station, Boolean stop, Boolean trafficCalming, Boolean trafficSignal, Boolean turningLoop, String sunriseSunset, String civilTwilight, String nauticalTwilight, String astronomicalTwilight) {
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
		NauticalTwilight = nauticalTwilight;
		AstronomicalTwilight = astronomicalTwilight;
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

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
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
		return NauticalTwilight;
	}

	public void setNauticalTwilight(String nauticalTwilight) {
		NauticalTwilight = nauticalTwilight;
	}

	public String getAstronomicalTwilight() {
		return AstronomicalTwilight;
	}

	public void setAstronomicalTwilight(String astronomicalTwilight) {
		AstronomicalTwilight = astronomicalTwilight;
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
				", NauticalTwilight='" + NauticalTwilight + '\'' +
				", AstronomicalTwilight='" + AstronomicalTwilight + '\'' +
				'}';
	}
}

package com.bbdd2promocion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.codecs.pojo.annotations.BsonIgnore;
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

	@Field(name = "distance")
	@Column(name = "distance")
	private Double distance;

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

	@Field(name = "description")
	@Column(name = "description", columnDefinition="TEXT")
	private String description;

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

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "accident_location_data_ID", referencedColumnName = "id")
	private AccidentLocationData accidentLocationData;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "accident_weather_data_ID", referencedColumnName = "id")
	private AccidentWeatherData accidentWeatherData;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "accident_terrain_data_ID", referencedColumnName = "id")
	private AccidentTerrainData accidentTerrainData;

	public Accident() {

	}

	public Accident(String csvId, String source, String tmc, Double severity, Date startTime, Date endTime, String description, Double distance, String sunriseSunset, String civilTwilight, String nauticalTwilight, String astronomicalTwilight) {
		this.csvId = csvId;
		this.source = source;
		this.tmc = tmc;
		this.severity = severity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.distance = distance;
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

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public AccidentLocationData getAccidentLocationData() {
		return accidentLocationData;
	}

	public void setAccidentLocationData(AccidentLocationData accidentLocationData) {
		this.accidentLocationData = accidentLocationData;
	}

	public AccidentWeatherData getAccidentWeatherData() {
		return accidentWeatherData;
	}

	public void setAccidentWeatherData(AccidentWeatherData accidentWeatherData) {
		this.accidentWeatherData = accidentWeatherData;
	}

	public AccidentTerrainData getAccidentTerrainData() {
		return accidentTerrainData;
	}

	public void setAccidentTerrainData(AccidentTerrainData accidentTerrainData) {
		this.accidentTerrainData = accidentTerrainData;
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
				", distance=" + distance +
				", sunriseSunset='" + sunriseSunset + '\'' +
				", civilTwilight='" + civilTwilight + '\'' +
				", NauticalTwilight='" + nauticalTwilight + '\'' +
				", AstronomicalTwilight='" + astronomicalTwilight + '\'' +
				'}';
	}
}

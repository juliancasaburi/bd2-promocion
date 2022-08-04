package com.bbdd2promocion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Entity
@Table(name = "accident_weather_data")
public class AccidentWeatherData {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @BsonIgnore
    @JsonIgnore
    private Long id;

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

    public AccidentWeatherData() {
    }

    public AccidentWeatherData(String weatherTimestamp, Double temperature, Double windChill, Double humidity, Double pressure, Double visibility, String windDirection, Double windSpeed, Double precipitation, String weatherCondition) {
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
}
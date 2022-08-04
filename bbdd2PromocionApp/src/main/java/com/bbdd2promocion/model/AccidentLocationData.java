package com.bbdd2promocion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Field;

import org.locationtech.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "accident_location_data")
public class AccidentLocationData {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @BsonIgnore
    @JsonIgnore
    private Long id;

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

    @Column(name = "point")
    @BsonIgnore
    private Point point;

    @Field(name = "endLat")
    @Column(name = "end_lat")
    private String endLat;

    @Field(name = "endLng")
    @Column(name = "end_lng")
    private String endLng;

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

    public AccidentLocationData(){

    }

    public AccidentLocationData(String startLat, String startLng, GeoJsonPoint startLocation, String endLat, String endLng, String number, String street, String side, String city, String county, String state, String zipcode, String country, String timezone, String airportCode, Point point) {
        this.startLat = startLat;
        this.startLng = startLng;
        this.startLocation = startLocation;
        this.endLat = endLat;
        this.endLng = endLng;
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
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public GeoJsonPoint getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(GeoJsonPoint startLocation) {
        this.startLocation = startLocation;
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

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
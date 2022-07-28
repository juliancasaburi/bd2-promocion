package com.bbdd2promocion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Entity
@Table(name = "accident_terrain_data")
public class AccidentTerrainData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @BsonIgnore
    @JsonIgnore
    private Long id;

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

    public AccidentTerrainData() {
    }

    public AccidentTerrainData(Long id, Boolean amenity, Boolean bump, Boolean crossing, Boolean giveWay, Boolean junction, Boolean noExit, Boolean railway, Boolean roundabout, Boolean station, Boolean stop, Boolean trafficCalming, Boolean trafficSignal, Boolean turningLoop) {
        this.id = id;
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setNoExit(Boolean noExit) {
        this.noExit = noExit;
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
}
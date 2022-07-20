package com.bbdd2promocion.repository.mongo.projections;

import java.util.List;

public class LocationCount {

    private List<Double> startLocation;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Double> getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(List<Double> startLocation) {
        this.startLocation = startLocation;
    }
}

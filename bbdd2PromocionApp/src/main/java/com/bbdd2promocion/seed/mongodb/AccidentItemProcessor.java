package com.bbdd2promocion.seed.mongodb;

import com.bbdd2promocion.model.Accident;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class AccidentItemProcessor implements ItemProcessor<Accident, Accident> {

    @Override
    public Accident process(Accident accident) throws Exception {

        accident.setStartLocation(new GeoJsonPoint(Double.parseDouble(accident.getStartLng()), Double.parseDouble(accident.getStartLat())));

        return accident;
    }

}

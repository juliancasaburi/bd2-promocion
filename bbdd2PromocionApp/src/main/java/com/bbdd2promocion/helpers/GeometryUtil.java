package com.bbdd2promocion.helpers;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class GeometryUtil {

  public static final int SRID = 4326; // longitude, latitude
  private static final WKTReader wktReader = new WKTReader();

  private static Geometry wktToGeometry(String wellKnownText) {
    Geometry geometry = null;

    try {
      geometry = wktReader.read(wellKnownText);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return geometry;
  }

  public static Point parseLocation(double x, double y) {
    Geometry geometry = GeometryUtil.wktToGeometry(String.format("POINT (%s %s)", x, y));
    Point p = (Point) geometry;
    p.setSRID(SRID);
    return p;
  }
}

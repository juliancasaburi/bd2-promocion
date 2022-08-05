package com.bbdd2promocion.repository.mongo.projections;

public class HourCount {

  private int hour;
  private int count;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {

    this.count = count;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }
}

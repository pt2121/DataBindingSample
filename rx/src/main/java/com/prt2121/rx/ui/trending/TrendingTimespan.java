package com.prt2121.rx.ui.trending;

import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;

public enum TrendingTimespan {
  DAY("today", 1, DurationFieldType.days()),
  WEEK("last week", 1, DurationFieldType.weeks()),
  MONTH("last month", 1, DurationFieldType.months());

  private final String name;
  private final int duration;
  private final DurationFieldType durationType;

  TrendingTimespan(String name, int duration, DurationFieldType durationType) {
    this.name = name;
    this.duration = duration;
    this.durationType = durationType;
  }

  public DateTime createdSince() {
    return DateTime.now().withFieldAdded(durationType, -duration);
  }

  @Override public String toString() {
    return name;
  }
}

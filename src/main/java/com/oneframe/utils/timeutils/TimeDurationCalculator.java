package com.oneframe.utils.timeutils;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

public class TimeDurationCalculator {

  private DateTime startDateTime;
  private DateTime endDateTime;

  private int minutesElapsed;
  private int secondsElapsed;
  private int totalSeconds;

  /**
   * Start the timer.
   */
  public void start() {
    startDateTime = new DateTime(System.currentTimeMillis());
  }

  /**
   * Stop the timer.
   */
  public void stop() {
    endDateTime = new DateTime(System.currentTimeMillis());
  }

  /**
   * Calculate the time Difference between two times by {@link #start()} and {@link #stop()}.
   */
  public void calculate() {
    if (startDateTime == null || endDateTime == null) {
      throw new IllegalStateException("Calculate method is called without start and stop");
    }
    int seconds = Seconds.secondsBetween(startDateTime, endDateTime).getSeconds();
    totalSeconds = seconds;

    minutesElapsed = seconds / 60;
    secondsElapsed = seconds % 60;
  }

  /**
   * Get the Text description of the time elapsed.
   *
   * @return {@link String} format description of time.
   */
  public String getTimeElapsed() {
    if (minutesElapsed == 0) {
      return secondsElapsed + " seconds ";
    } else {
      return minutesElapsed + " minutes " + secondsElapsed + " seconds";
    }
  }

  /**
   * Get the total seconds elapsed between two times by {@link #start()} and {@link #stop()}.
   *
   * @return Total number of seconds.
   */
  public int getTotalSecondsElapsed() {
    return totalSeconds;
  }
}

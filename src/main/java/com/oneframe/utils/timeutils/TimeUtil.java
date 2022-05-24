package com.oneframe.utils.timeutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TimeUtil class is used to get the Formatted Current Time. Formatting used : dd MMM yyyy
 * HH:mm:ss:SSS.
 */
public class TimeUtil {

  private static final String DATE_FORMAT = "dd MMM yyyy HH:mm:ss:SSS";

  private TimeUtil() {
    throw new AssertionError("TimeUtil class cant be instantiated");
  }

  /**
   * This method Format the current date and time in below format.
   *
   * @return current time of the machine.
   * @author poras.suryawanshi
   */
  public static String getCurrentTime() {
    final Calendar calendar = Calendar.getInstance();
    final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    return dateFormat.format(calendar.getTime());
  }
}

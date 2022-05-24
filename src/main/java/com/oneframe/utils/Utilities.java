package com.oneframe.utils;

import java.util.ResourceBundle;

public class Utilities {

  private Utilities() {
    LogPrinter.printLog("Can be instantiated");
  }

  private static final ResourceBundle rb1;
  private static final ResourceBundle rb2;

  static {
    rb1 = ResourceBundle.getBundle("config/config");
    String environmentStr = getConfigProperties("Environment");
    System.out.println("Execution Environment: " + environmentStr);
    rb2 = ResourceBundle.getBundle("config/" + environmentStr + "config");
  }

  /**
   * get config properties.
   *
   * @param keyString - key string whose value tp be fetched.
   * @return - key value
   * @author sudheer.singh
   */
  public static String getConfigProperties(String keyString) {
    return rb1.getString(keyString);
  }

  /**
   * get environment config properties.
   *
   * @param keyString - key string whose value tp be fetched.
   * @return - key value
   * @author sudheer.singh
   */
  public static String getEnvironmentProperties(String keyString) {
    return rb2.getString(keyString);
  }
}

package com.oneframe.utils;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

/**
 * Utility Class to Print the logs to the Console. {@link LogPrinter} works on the configurator
 * passed to it using xml file located in the root of the project directory.
 */
public class LogPrinter {

  private LogPrinter() {
    printLog("Can not create object of LogPrinter class");
  }

  private static Logger logger = LoggerFactory.getLogger(LogPrinter.class);

  static {
    DOMConfigurator.configure("log4j.xml");
  }

  /**
   * Print the log statements to the console.
   *
   * @param message - Message to print
   */
  public static void printLog(String message) {
    logger.info(message);
    Reporter.log(message);
  }
}

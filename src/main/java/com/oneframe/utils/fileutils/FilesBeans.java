package com.oneframe.utils.fileutils;

/**
 * FilesBeans class is POJO which allows you to set and get File fields to be used across scenarios.
 * FilesBeans design pattern follows the Singleton Design Pattern, with only a single instance
 * present at the scenario level.
 */
public class FilesBeans {

  private String sourceLocation;
  private String targetLocation;
  private String fileName;
  private static FilesBeans filesBeans;

  /**
   * Private no argument constructor for FilesBeans restricting instance creation.
   */
  private FilesBeans() {

  }

  /**
   * Initialize the Bean static singleton instance.
   */
  private static void initFileBean() {
    if (filesBeans == null) {
      filesBeans = new FilesBeans();
    }
  }

  /**
   * Set source File location in this format:- (System.getProperty("user.dir") +
   * "\\src\\test\\resources\\testData\\generateAlert\\")).
   *
   * @param sourceLocation - source file location.
   */
  public static void setSourceFileLocation(String sourceLocation) {
    if (filesBeans == null) {
      initFileBean();
    }
    filesBeans.sourceLocation = sourceLocation;
  }

  /**
   * Get source file location.
   *
   * @return - source file location.
   */
  public static String getSourceFileLocation() {
    if (filesBeans == null) {
      initFileBean();
    }
    return filesBeans.sourceLocation;
  }

  /**
   * set target file location in this format:- (System.getProperty("user.dir") +
   * "\\src\\test\\resources\\testData\\generateAlert\\"))..
   *
   * @param targetLocation - target file location.
   */
  public static void setTargetFileLocation(String targetLocation) {
    if (filesBeans == null) {
      initFileBean();
    }
    filesBeans.targetLocation = targetLocation;
  }

  /**
   * Get target file location.
   *
   * @return - target file location.
   */
  public static String getTargetFileLocation() {
    if (filesBeans == null) {
      initFileBean();
    }
    return filesBeans.targetLocation;
  }

  /**
   * Set file name.
   *
   * @param fileName - file name.
   */
  public static void setFileName(String fileName) {
    filesBeans.fileName = fileName;
  }

  /**
   * Get file name.
   *
   * @return - file name.
   */
  public static String getFileName() {
    return filesBeans.fileName;
  }
}

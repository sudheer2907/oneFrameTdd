package com.oneframe.constants;

public final class JsonConstants {

  /**
   * JSONConstants private constructor to restrict the instance Creation from any Class.
   */
  private JsonConstants() {
    throw new AssertionError(
        "Cant initialize the Constructor for Class : " + JsonConstants.class.getSimpleName());
  }

  public static final int OK_STATUS_CODE = 200;
  public static final int OK_STATUS_CREATED = 201;
  public static final int OK_STATUS_DUPLICATE = 202;
  public static final int OK_STATUS_CONFLICT = 409;
  public static final int OK_STATUS_NO_CONTENT = 204;
  public static final String OK_STATUS_MESSAGE = "OK";
  public static final String JSON_FILE_EXTENSION = ".json";
  public static final int UNAUTHORIZED_STATUS_CODE = 401;
  public static final String INDEX_ZERO_STR = "[0].";
  public static final String DOT = ".";
  public static final String TICKET_CLOSED_STATUS = "109";
}

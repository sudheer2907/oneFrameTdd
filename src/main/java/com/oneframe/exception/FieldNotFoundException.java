package com.oneframe.exception;

/**
 * The FieldNotFoundException wraps all checked standard Java exception and enriches them with a
 * custom error code. USe this exception to show that Error has occurred when Field is not found in
 * JSON or Database Resultset response.
 */
public class FieldNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -4915139638138264979L;

  public FieldNotFoundException(String field) {
    super(field + " field not found");
    this.errorMessage = field + " field not found";
  }

  public FieldNotFoundException(Throwable cause) {
    super(cause);
    this.errorMessage = cause.getMessage();
  }

  private final String errorMessage;

  @Override
  public String getMessage() {
    return errorMessage;
  }
}

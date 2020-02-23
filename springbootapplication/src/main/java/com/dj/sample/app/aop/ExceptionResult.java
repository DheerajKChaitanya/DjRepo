package com.dj.sample.app.aop;

/**
 * @author kdheeraj
 *
 */
@SuppressWarnings("javadoc")
public class ExceptionResult {

  private int errorCode;

  private String message;

  private String errorMessage;

  private String exceptionMessage;

  private StackTraceElement[] stackTrace;

  /**
   * The constructor.
   *
   * @param errorCode
   * @param message
   * @param errorMessage
   * @param exceptionMessage
   * @param stackTrace
   */
  public ExceptionResult(int errorCode, String message, String errorMessage, String exceptionMessage,
      StackTraceElement[] stackTrace) {
    super();
    this.errorCode = errorCode;
    this.message = message;
    this.errorMessage = errorMessage;
    this.exceptionMessage = exceptionMessage;
    this.stackTrace = stackTrace;
  }

  /**
   * The constructor.
   */
  public ExceptionResult() {
    super();
  }

  /**
   * @return errorMessage
   */
  public String getErrorMessage() {

    return this.errorMessage;
  }

  /**
   * @return errorCode
   */
  public int getErrorCode() {

    return this.errorCode;
  }

  /**
   * @param errorCode new value of {@link #geterrorCode}.
   */
  public void setErrorCode(int errorCode) {

    this.errorCode = errorCode;
  }

  /**
   * @return message
   */
  public String getMessage() {

    return this.message;
  }

  /**
   * @param message new value of {@link #getmessage}.
   */
  public void setMessage(String message) {

    this.message = message;
  }

  /**
   * @return exceptionMessage
   */
  public String getExceptionMessage() {

    return this.exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {

    this.exceptionMessage = exceptionMessage;
  }

  /**
   * @return stackTrace
   */
  public StackTraceElement[] getStackTrace() {

    return this.stackTrace;
  }

  public void setStackTrace(StackTraceElement[] stackTrace) {

    this.stackTrace = stackTrace;
  }

  /**
   * @param errorMessage new value of {@link #geterrorMessage}.
   */
  public void setErrorMessage(String errorMessage) {

    this.errorMessage = errorMessage;
  }

}

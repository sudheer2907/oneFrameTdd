package com.oneframe.testnglistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.oneframe.utils.LogPrinter;
import com.oneframe.utils.WebDriverFactory;

public class TestNGListeners implements ITestListener, IRetryAnalyzer {

  private int retryCount = 0;
  private static final int maxRetryCount = 2;

  public void onTestStart(ITestResult result) {
    //System.out.println("New Test Started:" + result.getName());
  }

  public void onTestSuccess(ITestResult result) {
    //System.out.println("Test Successfully Finished:" + result.getName());
  }

  public void onTestFailure(ITestResult result) {
    System.out.println("Test Failed:" + result.getName());
    WebDriverFactory.captureScreenShot(WebDriverFactory.getDriver(),
        result.getTestName() + System.currentTimeMillis());
  }

  public void onTestSkipped(ITestResult result) {
    //System.out.println("Test Skipped:" + result.getName());
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    //System.out.println("Test Failed but within success percentage:" + result.getName());
  }

  public void onStart(ITestContext context) {
    //System.out.println("This is onStart method:" + context.getOutputDirectory());
  }

  public void onFinish(ITestContext context) {
    //System.out.println("This is onFinish method:" + context.getPassedTests());
    //System.out.println("This is onFinish method:" + context.getFailedTests());
  }

  @Override
  public boolean retry(ITestResult result) {
    LogPrinter.printLog("Retry:" + retryCount);
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }

}

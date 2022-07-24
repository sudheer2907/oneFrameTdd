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
    LogPrinter.printLog("Executing method:" + result.getName());
  }

  public void onTestSuccess(ITestResult result) {
    LogPrinter.printLog(result.getName() + " method passed");
  }

  public void onTestFailure(ITestResult result) {
    LogPrinter.printLog(result.getName() + " method failed");
    WebDriverFactory.captureScreenShot(WebDriverFactory.getDriver(),
        result.getTestName() + System.currentTimeMillis());
  }

  public void onTestSkipped(ITestResult result) {
    LogPrinter.printLog(result.getName() + " method skipped");
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    //LogPrinter.printLog("Test Failed but within success percentage:" + result.getName());
  }

  public void onStart(ITestContext context) {
    System.out.println("Execution started:" + context.getOutputDirectory());
  }

  public void onFinish(ITestContext context) {
    System.out.println(context.getPassedTests());
    System.out.println("This is onFinish method:" + context.getFailedTests());
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

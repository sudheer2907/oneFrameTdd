package com.oneframe.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
  public static WebDriver driver;
  public static Properties prop;
  public static ExtentTest test;
  public static ExtentReports report;

  public TestBase() throws IOException {
    prop = new Properties();
    FileInputStream file = new FileInputStream(
        "C:\\Users\\jamadaga\\Rapid\\CCUX Automation\\src\\main\\java\\com\\ccux\\qa\\config\\config.properties");
    prop.load(file);
  }

  public static void initilization() {
    String browserName = prop.getProperty("browser");
    if (browserName.equals("Chrome")) {
      System.setProperty("webdriver.chrome.driver",
          "C:\\Users\\jamadaga\\Rapid\\Selenium Study\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
    }
    if (browserName.equals("firefox")) {
      System.setProperty("webdriver.gecko.driver",
          "C:\\Users\\jamadaga\\Rapid\\Selenium Study\\geckodriver-v0.27.0-win64\\geckodriver.exe");
      driver = new FirefoxDriver();
    }
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get(prop.getProperty("url"));
    report = new ExtentReports(prop.getProperty("driveextentReports"), false);
  }

  public static String capture(WebDriver driver) throws IOException {
    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File Dest = new File(prop.getProperty("Screenshots") + System.currentTimeMillis() + ".png");
    String errflpath = Dest.getAbsolutePath();
    FileHandler.copy(scrFile, Dest);
    return errflpath;
  }

}

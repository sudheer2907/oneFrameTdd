package com.oneframe.tests.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.oneframe.helper.ui.InternetHerokuappHelper;
import com.oneframe.utils.LogPrinter;
import com.oneframe.utils.WebDriverFactory;

import junit.framework.Assert;

public class TestInternetHerokuappHelper {
  InternetHerokuappHelper internetHerokuappHelper;

  @BeforeClass
  public void beforeClass() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);
    internetHerokuappHelper = new InternetHerokuappHelper();
  }

  @AfterClass
  public void afterClass() {
    WebDriverFactory.closeCurrentBrowserWindow();
  }

  @BeforeMethod
  public void beforeMethod() {}

  @AfterMethod
  public void afterMethod() {
    WebDriverFactory.getDriver().navigate().back();
  }

  @Test(priority = 1, enabled = true)
  public void testAbTestControl() {
    internetHerokuappHelper.clickOnAbTesting();
    WebDriverFactory.waitForPageToLoad(30);
    Assert.assertTrue(internetHerokuappHelper.getAbTestControlDescription().equalsIgnoreCase(
        "Also known as split testing. This is a way in which businesses are able to simultaneously "
            + "test and learn different versions of a page to see which text and/or functionality works "
            + "best towards a desired outcome (e.g. a user action such as a click-through)."));
    LogPrinter.printLog("AB Test Control page is working fine.");
  }

  @Test(priority = 1, enabled = true)
  public void testAddRemoveElements() {
    internetHerokuappHelper.clickOnAddRemoveElements();
    WebDriverFactory.waitForPageToLoad(30);
    Assert.assertTrue(internetHerokuappHelper.isAddRemoveElementsPageDisplayed());
    LogPrinter.printLog("Add Remove Page is opened.");
    internetHerokuappHelper.clickOnAddElementButton();
    Assert.assertTrue(internetHerokuappHelper.isDeleteButtonDisplayed());
    LogPrinter.printLog("Add Remove button page is working fine");
  }

  @Test(priority = 1, enabled = true)
  public void testBasicAuth() {
    internetHerokuappHelper.clickOnBasicAuth();

  }

  @Test(priority = 1, enabled = true)
  public void testBrokenImages() {
    internetHerokuappHelper.clickOnBrokenImage();
    Assert.assertTrue(internetHerokuappHelper.isBrokenPageDisplayed());
    LogPrinter.printLog("Broken Image page is getting displayed.");
    boolean flag = false;
    for (WebElement image : WebDriverFactory.getDriver().findElements(By.cssSelector("img"))) {
      if (WebDriverFactory.isImageBroken(image) == true) {
        flag = true;
      }
    }
    Assert.assertFalse(flag);
  }

  @Test(priority = 1, enabled = true)
  public void testCheckBox() {
    internetHerokuappHelper.clickOnCheckBox();
    Assert.assertTrue(internetHerokuappHelper.isCheckBoxPageDisplayed());
    LogPrinter.printLog("Checkbox page is displayed.");
    Assert.assertTrue(internetHerokuappHelper.isCheckBox2Checked());
    LogPrinter.printLog("Checkbox 2 is checked.");
  }

  @Test(priority = 1, enabled = true)
  public void testContentMenu() throws InterruptedException {
    internetHerokuappHelper.clickOnContentMenu();
    Assert.assertTrue(internetHerokuappHelper.isContentMenuDisplayed());
    LogPrinter.printLog("Content Menu page is displayed.");
    internetHerokuappHelper.rightClickOnTheBlankBoxOnTheContentMenu();
    Assert.assertTrue(WebDriverFactory.isAlertDisplayed(10));
    WebDriverFactory.acceptAnAlertDisplayed(10);
    LogPrinter.printLog("Alert pop up displayed on the content menu page.");
    TimeUnit.SECONDS.sleep(10);
  }

  @Test(priority = 1, enabled = true)
  public void testDigestAuthentication() {
    internetHerokuappHelper.clickOnDigestAuthentication();
  }

  @Test(priority = 1, enabled = true)
  public void testDissapearingMessage() {
    internetHerokuappHelper.clickOnDissapperaingElements();
  }


}

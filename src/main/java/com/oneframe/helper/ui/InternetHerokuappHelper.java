package com.oneframe.helper.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneframe.utils.WebDriverFactory;

public class InternetHerokuappHelper {

  public InternetHerokuappHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  @FindBy(xpath = "//a[contains(text(),'A/B Testing')]")
  private WebElement abTesting;

  @FindBy(xpath = "//div[@class='example']/p")
  private WebElement labelTextabTesting;

  @FindBy(xpath = "//a[contains(text(),'Add/Remove Elements')]")
  private WebElement btnAddRemoveElements;

  @FindBy(xpath = "//h3[contains(text(),'Add/Remove Elements')]")
  private WebElement labelTextAddRemoveButton;

  @FindBy(xpath = "//button[contains(text(),'Add Element')]")
  private WebElement btnAddElements;

  @FindBy(xpath = "//button[contains(text(),'Delete')]")
  private WebElement btnDelete;

  @FindBy(xpath = "//a[contains(text(),'Basic Auth')]")
  private WebElement btnBasicAurh;

  @FindBy(xpath = "//a[contains(text(),'Broken Images')]")
  private WebElement btnBrokenImage;

  @FindBy(xpath = "//h3[contains(text(),'Broken Images')]")
  private WebElement labelTextBrokenImage;

  @FindBy(xpath = "//a[contains(text(),'Challenging DOM')]")
  private WebElement btnChallenginDom;

  @FindBy(xpath = "//a[contains(text(),'Checkboxes')]")
  private WebElement btnCheckBox;

  @FindBy(xpath = "//h3[contains(text(),'Checkboxes')]")
  private WebElement labelTextCheckbox;

  @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
  private WebElement chkBoxCheckbox2;

  @FindBy(xpath = "//a[contains(text(),'Context Menu')]")
  private WebElement btnContentMenu;

  @FindBy(xpath = "//div[@id='hot-spot']")
  private WebElement boxContentMenu;

  @FindBy(xpath = "//h3[contains(text(),'Context Menu')]")
  private WebElement labelTextContentMenu;

  @FindBy(xpath = "//a[contains(text(),'Digest Authentication')]")
  private WebElement btnDigestAuthentication;

  @FindBy(xpath = "//a[contains(text(),'Disappearing Elements')]")
  private WebElement btnDissapperingElements;

  @FindBy(xpath = "//a[contains(text(),'Drag and Drop')]")
  private WebElement btnDragAndDrop;

  @FindBy(xpath = "//a[contains(text(),'Dropdown')]")
  private WebElement btnDropdwon;

  @FindBy(xpath = "//a[contains(text(),'Dynamic Content')]")
  private WebElement btnDynamicContent;

  @FindBy(xpath = "//a[contains(text(),'Dynamic Controls')]")
  private WebElement btnDynamicControls;

  @FindBy(xpath = "//a[contains(text(),'Dynamic Loading')]")
  private WebElement btnDynamicLoading;

  public void clickOnAbTesting() {
    WebDriverFactory.clickWebElement(abTesting);
  }

  public String getAbTestControlDescription() {
    WebDriverFactory.isElementVisible(labelTextabTesting, 30);
    return labelTextabTesting.getText();
  }

  public void clickOnAddRemoveElements() {
    WebDriverFactory.clickWebElement(btnAddRemoveElements);
  }

  public boolean isAddRemoveElementsPageDisplayed() {
    return WebDriverFactory.isElementVisible(labelTextAddRemoveButton, 30);
  }

  public void clickOnAddElementButton() {
    WebDriverFactory.clickWebElement(btnAddElements);
  }

  public boolean isDeleteButtonDisplayed() {
    return WebDriverFactory.isElementVisible(btnDelete, 30);
  }

  public void clickOnBrokenImage() {
    WebDriverFactory.clickWebElement(btnBrokenImage);
  }

  public boolean isBrokenPageDisplayed() {
    return WebDriverFactory.isElementVisible(labelTextBrokenImage, 30);
  }

  public void clickOnCheckBox() {
    WebDriverFactory.clickWebElement(btnCheckBox);
  }

  public boolean isCheckBoxPageDisplayed() {
   return WebDriverFactory.isElementVisible(labelTextCheckbox, 30); 
  }

  public boolean isCheckBox2Checked() {
    return chkBoxCheckbox2.isSelected();
  }

  public void clickOnContentMenu() {
    WebDriverFactory.clickWebElement(btnContentMenu);
  }

  public boolean isContentMenuDisplayed() {
    return WebDriverFactory.isElementVisible(labelTextContentMenu, 30);
  }

  public void rightClickOnTheBlankBoxOnTheContentMenu() {
    WebDriverFactory.rightClickOnTheWebElement(boxContentMenu);
  }

  public void clickOnDigestAuthentication() {
    WebDriverFactory.clickWebElement(btnDigestAuthentication);
  }

  public void clickOnDissapperaingElements() {
    WebDriverFactory.clickWebElement(btnDissapperingElements);
  }

  public void clickOnChallengingDom() {
    WebDriverFactory.clickWebElement(btnChallenginDom);
  }

  public void clickOnBasicAuth() {
    WebDriverFactory.clickWebElement(btnBasicAurh);
  }

}

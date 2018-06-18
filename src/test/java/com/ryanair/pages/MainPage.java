package com.ryanair.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class=\"username\" and contains(text(), \"Log in\")]")
    private WebElement loginButton;

    @FindBy(xpath = "//form[@name=\"formFlightSearch\"]//button[contains(@ng-click,\"extendForm\")]")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@aria-labelledby=\"label-airport-selector-from\"]")
    private WebElement fromField;

    @FindBy(xpath = "//input[@aria-labelledby=\"label-airport-selector-to\"]")
    private WebElement toField;

    @FindBy(xpath = "//input[@aria-label=\"Fly out: - DD\"]")
    private WebElement dayOutField;

    @FindBy(xpath = "//input[@aria-label=\"Fly out: - MM\"]")
    private WebElement monthOutField;

    @FindBy(xpath = "//input[@aria-label=\"Fly out: - YYYY\"]")
    private WebElement yearOutField;

    @FindBy(xpath = "//input[@aria-label=\"Fly back: - DD\"]")
    private WebElement dayBackField;

    @FindBy(xpath = "//input[@aria-label=\"Fly back: - MM\"]")
    private WebElement monthBackField;

    @FindBy(xpath = "//input[@aria-label=\"Fly back: - YYYY\"]")
    private WebElement yearBackField;

    //@FindBy(xpath = "//div[@label=\"Passengers:\"]")
    @FindBy(xpath = "//div[contains(@aria-label, \"Adult\")]")
    private WebElement passengersField;

    @FindBy(xpath = "//input[contains(@aria-label, \"Adults\")]")
    private WebElement adultsNumberField;

    @FindBy(xpath = "//button[@ng-keypress=\"searchFlights()\"]")
    private WebElement searchFlighsButton;

    @FindBy(xpath = "//cookie-pop-up//core-icon")
    private WebElement cookiePopUp;

    public void goToLogin() {
        loginButton.click();
    }

    public void enterOrigin(String city) {
        fromField.click();
        fromField.sendKeys(city);
    }

    public void enterDestination(String city) {
        toField.sendKeys(city);
        //to exit from pick country menu
        continueButton.sendKeys(Keys.ENTER);
    }

    public void selectInitialDate(String day, String month, String year) {
        waitForElement(dayOutField);
        dayOutField.clear();
        dayOutField.sendKeys(day);
        monthOutField.clear();
        monthOutField.sendKeys(month);
        yearOutField.clear();
        yearOutField.sendKeys(year);
    }

    public void selectFinalDate(String day, String month, String year) {
        dayBackField.clear();
        dayBackField.sendKeys(day);
        monthBackField.clear();
        monthBackField.sendKeys(month);
        yearBackField.clear();
        yearBackField.sendKeys(year);
    }

    public void selectPassengers(String number) {
        Actions actions = new Actions(driver);
        actions.moveToElement(passengersField).click().perform();
        adultsNumberField.clear();
        adultsNumberField.sendKeys(number);
        adultsNumberField.submit();
    }

    public void setSearchFlighsButton() {
        searchFlighsButton.click();
    }

    public void closeCookiePopUp() {
        cookiePopUp.click();
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}

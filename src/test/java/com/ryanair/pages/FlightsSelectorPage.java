package com.ryanair.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsSelectorPage {


    @FindBy(xpath = "(//div[@class=\"flights-table-price\"])[2]")
    private WebElement selectToFlightButton;

    @FindBy(xpath = "(//div[@class=\"flights-table-price\"])[4]")
    private WebElement selectReturnFlightButton;

    @FindBy(xpath = "//span[contains(text(), \"Standard fare\")]")
    private WebElement selectStandardFareElement;

    @FindBy(xpath = "//span[@class=\"type\" and contains(text(), \"Standard fare\")]")
    private WebElement selectReturnStandardFareElement;

    public void selectFlights(WebDriver driver) {
        //select to flight
        waitForElementToBePresent(driver, selectToFlightButton);
        selectToFlightButton.click();
        waitForElementToBePresent(driver, selectStandardFareElement);
        selectStandardFareElement.click();

        //select return flight
        waitForElementToBePresent(driver, selectReturnFlightButton);
        selectReturnFlightButton.click();
        waitForElementToBePresent(driver, selectReturnStandardFareElement);
        selectReturnStandardFareElement.click();
    }

    public void waitForElementToBePresent(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

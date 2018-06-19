package com.ryanair.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsSelectorPage {

    WebDriver driver;

    public FlightsSelectorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "(//span[contains(text(), \"from\")])[2]")
    private WebElement selectToFlightButton;

    @FindBy(xpath = "(//span[contains(text(), \"from\")])[2]")
    private WebElement selectReturnFlightButton;

    @FindBy(xpath = "//span[contains(text(), \"Standard fare\")]")
    private WebElement selectStandardFareElement;

    @FindBy(xpath = "(//div[@class=\"flights-table-fares__benefit-list\"])[1]")
    private WebElement selectReturnStandardFareElement;

    @FindBy(xpath = "//button[./span[@translate=\"trips.summary.buttons.btn_continue\"]]")
    private WebElement continueButton;

    public void selectFlights() {
        //select to flight
        waitForElementToBeClickable(selectToFlightButton);
        selectToFlightButton.click();

        Actions actions = new Actions(driver);

        actions.moveToElement(selectStandardFareElement).click().perform();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //select return flight
        waitForElementToBeClickable(selectReturnFlightButton);
        selectReturnFlightButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.moveToElement(selectReturnStandardFareElement).click().perform();

        waitForElementToBeClickable(continueButton);
        continueButton.click();
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}

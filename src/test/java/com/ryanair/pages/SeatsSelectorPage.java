package com.ryanair.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeatsSelectorPage {

    WebDriver driver;

    public SeatsSelectorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@ng-click, \"closeSeat\")]")
    private WebElement noThanksButton;

    public void closeSeatSelector() {
        waitForElementToBeVisible(noThanksButton);
        noThanksButton.click();
        if (noThanksButton.isDisplayed()) {
            waitForElementToClose(noThanksButton);
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToClose(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}

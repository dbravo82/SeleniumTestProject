package com.ryanair.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingExtrasPage {

    WebDriver driver;

    public BookingExtrasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[./span[contains(text(), \"Check out\")]]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[contains(text(), \"No thanks\")]")
    private WebElement noThanksButton;

    public void clickCheckout() {
        waitForElementToBeClickable(checkoutButton);

        checkoutButton.click();
        noThanksButton.click();
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

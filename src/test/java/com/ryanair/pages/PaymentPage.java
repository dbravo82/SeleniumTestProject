package com.ryanair.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//select[./option[contains(text(), \"Title\")]])[1]")
    private WebElement firstPassengerTitleField;

    @FindBy(xpath = "(//input[contains(@name, \"firstName\")])[1]")
    private WebElement firstPassengerNameField;

    @FindBy(xpath = "(//input[contains(@name, \"lastName\")])[1]")
    private WebElement firstPassengerSurnameField;

    @FindBy(xpath = "(//select[./option[contains(text(), \"Title\")]])[2]")
    private WebElement secondPassengerTitleField;

    @FindBy(xpath = "(//input[contains(@name, \"firstName\")])[2]")
    private WebElement secondPassengerNameField;

    @FindBy(xpath = "(//input[contains(@name, \"lastName\")])[2]")
    private WebElement secondPassengerSurnameField;

    @FindBy(xpath = "//select[@name=\"phoneNumberCountry\"]")
    private WebElement phoneNumberCountryField;

    @FindBy(xpath = "//input[@name=\"phoneNumber\"]")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@name = \"cardNumber\"]")
    private WebElement cardNumberField;

    @FindBy(xpath = "//select[@name=\"cardType\"]")
    private WebElement cardTypeField;

    @FindBy(xpath = "//select[@name=\"expiryMonth\"]")
    private WebElement cardExpiryMonthField;

    @FindBy(xpath = "//select[@name=\"expiryYear\"]")
    private WebElement cardExpiryYearField;

    @FindBy(xpath = "//input[@name=\"cardHolderName\"]")
    private WebElement cardHolderNameField;

    @FindBy(xpath = "//input[@name=\"securityCode\"]")
    private WebElement cardSecurityCodeField;

    @FindBy(xpath = "//input[@name=\"billingAddressAddressLine1\"]")
    private WebElement billingAddressField;

    @FindBy(xpath = "//input[@name=\"billingAddressCity\"]")
    private WebElement billingCityField;

    @FindBy(xpath = "//input[@name=\"billingAddressPostcode\"]")
    private WebElement billingPostCodeField;

    @FindBy(xpath = "//select[@name=\"billingAddressCountry\"]")
    private WebElement billingCountryField;

    @FindBy(xpath = "//button[contains(text(), \"Pay Now\")]")
    private WebElement payNowButton;

    @FindBy(xpath = "//input[@name=\"acceptPolicy\"]")
    private WebElement acceptPolicyCheckBox;

    @FindBy(xpath = "//prompt[@ng-switch-when=\"PaymentDeclined\"]")
    private WebElement paymentDeclinedMessage;

    public void giveFirstPassengerDetails(String name, String lastName, String title) {

        Select select = new Select(firstPassengerTitleField);
        select.selectByVisibleText(title);

        firstPassengerNameField.sendKeys(name);
        firstPassengerSurnameField.sendKeys(lastName);
    }

    public void giveSecondPassengerDetails(String name, String lastName, String title) {
        Select select = new Select(secondPassengerTitleField);
        select.selectByVisibleText(title);

        secondPassengerNameField.sendKeys(name);
        secondPassengerSurnameField.sendKeys(lastName);
    }

    public void fillPhoneNumberInfo(String country, String phoneNumber) {
        Select selectCountry = new Select(phoneNumberCountryField);
        selectCountry.selectByVisibleText(country);
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void fillCardInfo(String cardNumber, String cardType, String expiryMonth, String expiryYear
            , String cardSecurityCode, String cardHolderName) {

        cardNumberField.sendKeys(cardNumber);

        Select selectCardType = new Select(cardTypeField);
        selectCardType.selectByVisibleText(cardType);

        Select selectExpiryMonth = new Select(cardExpiryMonthField);
        selectExpiryMonth.selectByVisibleText(expiryMonth);

        Select selectExpiryYear = new Select(cardExpiryYearField);
        selectExpiryYear.selectByVisibleText(expiryYear);

        cardSecurityCodeField.sendKeys(cardSecurityCode);

        cardHolderNameField.sendKeys(cardHolderName);

    }

    public void fillBillingInfo(String billingAddress, String billingCity, String billingCountry, String billingPostCode) {

        billingAddressField.sendKeys(billingAddress);
        billingCityField.sendKeys(billingCity);
        Select selectBillingCountry = new Select(billingCountryField);
        selectBillingCountry.selectByVisibleText(billingCountry);
        billingPostCodeField.sendKeys(billingPostCode);
    }

    public void pay() {
        Actions actions = new Actions(driver);
        actions.moveToElement(acceptPolicyCheckBox).click().perform();
        payNowButton.click();
    }

    public boolean isDeclinedPayment() {

        waitForElement(paymentDeclinedMessage);
        return paymentDeclinedMessage.isDisplayed();
    }
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

package com.ryanair.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"emailAddress\"]")
    private WebElement emailField;

    @FindBy(xpath = "(//input[@name=\"password\"])[2]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"][.//span[contains(text(), \"Log in\")]]")
    private WebElement loginButton;

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        loginButton.click();
    }
}

package com.ryanair.tests.booking;

import com.ryanair.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BookingUpTest {

    private static final String MAIN_RYANAIR_PAGE = "https://www.ryanair.com/ie/en/";

    WebDriver webDriver;

    @Given("^user logs in and make a booking from Madrid to Ibiza on 25/09/2018 for 2 adults$")
    public void givenStatement() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.get(MAIN_RYANAIR_PAGE);
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        FlightsSelectorPage flightsPage = new FlightsSelectorPage(webDriver);
        SeatsSelectorPage seatsPage = new SeatsSelectorPage(webDriver);
        BookingExtrasPage extrasPage = new BookingExtrasPage(webDriver);

        mainPage.closeCookiePopUp();
        mainPage.goToLogin();
        loginPage.login("daniel.bravo82@gmail.com", "Test_1234");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainPage.enterOrigin("Madrid");
        mainPage.enterDestination("Ibiza");
        mainPage.selectInitialDate("25", "09", "2018");
        mainPage.selectFinalDate("28", "09", "2018");
        mainPage.selectPassengers("2");
        mainPage.setSearchFlighsButton();

        flightsPage.selectFlights();

        seatsPage.closeSeatSelector();

        extrasPage.clickCheckout();

    }

    @When("^user pays for booking with card number 2312334567213444 expiry on 03/2020 and ccv 333$")
    public void whenStatement() {
        PaymentPage paymentPage = new PaymentPage(webDriver);

        paymentPage.giveFirstPassengerDetails("Daniel", "Bravo", "Mr");
        paymentPage.giveSecondPassengerDetails("Ana", "Sanchez", "Mrs");
        paymentPage.fillPhoneNumberInfo("Spain", "623154786");
        paymentPage.fillCardInfo("2312334567213444", "MasterCard", "3", "2020",
                "333", "Daniel Bravo");
        paymentPage.fillBillingInfo("C\\ Rio ebro 4", "Madrid", "Spain", "28098");
        paymentPage.pay();
    }

    @Then("^user should get payment declined message$")
    public void thenStatement() {
        PaymentPage paymentPage = new PaymentPage(webDriver);

        Assert.assertTrue(paymentPage.isDeclinedPayment());
    }

}

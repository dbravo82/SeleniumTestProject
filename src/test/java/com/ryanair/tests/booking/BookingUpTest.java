package com.ryanair.tests.booking;

import com.ryanair.pages.FlightsSelectorPage;
import com.ryanair.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookingUpTest {

    private static final String MAIN_RYANAIR_PAGE = "https://www.ryanair.com/ie/en/";

    private WebDriver webDriver;
    private MainPage mainPage;
    private FlightsSelectorPage flightsPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/chromedriver");
        webDriver = new ChromeDriver();
        mainPage = PageFactory.initElements(webDriver,MainPage.class);
        flightsPage = PageFactory.initElements(webDriver, FlightsSelectorPage.class);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        //webDriver.close();
    }

    @Test
    public void selectDestinnationAndDates() {
        webDriver.get(MAIN_RYANAIR_PAGE);

        Date today = new Date();
        LocalDate localDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String day = String.valueOf(localDate.getDayOfMonth() + 2);
        String returnDay = String.valueOf(localDate.getDayOfMonth() + 5);
        String month = String.valueOf(localDate.getMonthValue() + 1);
        String year = String.valueOf(localDate.getYear());


        mainPage.closeCookiePopUp();
        mainPage.enterOrigin("Madrid");
        mainPage.enterDestination("Ibiza");
        mainPage.selectInitialDate(day, month, year);
        mainPage.selectFinalDate(returnDay, month, year);
        mainPage.selectPassengers("2", webDriver);
        mainPage.setSearchFlighsButton();

        flightsPage.selectFlights(webDriver);

    }
}

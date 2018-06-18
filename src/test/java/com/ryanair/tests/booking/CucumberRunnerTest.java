package com.ryanair.tests.booking;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        format = {"pretty","html:reports/test-report"}
)
public class CucumberRunnerTest {

}

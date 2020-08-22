package com.example.app;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * https://github.com/cucumber/cucumber-jvm/tree/master/spring
 * To run cucumber test.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty","html:target/cucumber"},
                glue = {"com.example.app.config.stepdefs"})
public class RunTest {


}


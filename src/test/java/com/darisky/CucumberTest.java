package com.darisky;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.darisky"},
        features = {"src/test/resources"},
        plugin = {"pretty","html:reports/html/cucumber.html", "json:reports/json/cucumber.json"}
)

public class CucumberTest {
}

package com.darisky;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Points to src/test/resources/features
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.darisky")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:reports/html/cucumber.html, json:reports/json/cucumber.json")
public class CucumberTest {
}

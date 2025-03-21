package testRunner;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")  // Path to the Features folder
@ConfigurationParameter(
  key = Constants.GLUE_PROPERTY_NAME, value = "stepDefinitions"
)
@ConfigurationParameter(  key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Activity1")

public class TestRunner {}
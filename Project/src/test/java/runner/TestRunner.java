package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Creator: Akash Deep
 * Description: This class is the test runner for Cucumber tests. It uses JUnit to run the tests
 * and specifies the location of the feature files and step definitions.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "./features", glue = "stepdefinition" )
public class TestRunner {
    
}

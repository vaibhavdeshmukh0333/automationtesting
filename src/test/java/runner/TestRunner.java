package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestRunner class to execute Cucumber tests.
 * Extends AbstractTestNGCucumberTests for TestNG integration.
 */
@CucumberOptions(
    features = "src/test/resources/Featurefiles",
    glue = {"stepDefinitions", "baseclass"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true,
    dryRun = false,
    tags = "@RFE01"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

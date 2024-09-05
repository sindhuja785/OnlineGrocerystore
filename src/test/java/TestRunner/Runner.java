package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Path to your .feature file
    glue = {"Stepdefinition"}, // Package where Stepdefinition are present
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
    monochrome = true,
    dryRun = true
)
public class Runner {
    // Empty class: this is just a bridge to run the tests
}


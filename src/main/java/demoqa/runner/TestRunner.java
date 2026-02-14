package demoqa.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/demoqa/features",
        glue = "demoqa.steps",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@smoke or @regression"
)
public class TestRunner {
}

package CustomerModule.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/CustomerModule/Features",
        glue = {"CustomerModule.Steps", "CustomerModule.Hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},tags = "@order")
public class testRunner {
}
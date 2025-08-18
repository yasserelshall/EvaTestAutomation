package DoctorPortal.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/DoctorPortal/Features",
        glue = {"DoctorPortal/Steps", "DoctorPortal/Hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"},tags = "@test")
public class testRunner {
}

package org.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.config.ConfigLoader;

@CucumberOptions(
        features = {
//              "src/test/resources/feature/google.feature",
                "src/test/resources/feature/login.feature"
        },
        glue = {
                "org.example.base",
                "org.example.hooks",
                "steps.example.google",
                "steps.example.common"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
        monochrome = true
)
public class CucumberTest extends AbstractTestNGCucumberTests {

}

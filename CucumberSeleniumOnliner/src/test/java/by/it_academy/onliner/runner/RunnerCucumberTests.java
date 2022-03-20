package by.it_academy.onliner.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/RunnerCucumberTests",
                "json:target/json-files/RunnerCucumberTests.json",
                "junit:target/junit_cucumber.xml"},
        monochrome = true,
        tags = "@smoke",
        glue = "by.it_academy.onliner",
        features = "classpath:by.it_academy.onliner.features"
)
public class RunnerCucumberTests extends AbstractTestNGCucumberTests {
}
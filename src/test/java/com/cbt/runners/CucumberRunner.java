package com.cbt.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =  "src\\test\\resources\\features",
        glue = "com/cbt/step_definitions",
        dryRun = false,
        tags = "@store_manager",
        plugin = {"html:target/default-cucumber-report",
                "json:target/cucumber.json"
        }
)
    public class CucumberRunner {


}

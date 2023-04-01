package org.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
                 glue= {"org.stepdefinitions","org.hooks"},
                 dryRun=false,monochrome=true,
                plugin= {"pretty","html:Cucumber-Report/Amazon.html","json:Cucumber-Report/Amazon.json","junit:Cucumber-Report/Amazon.xml"},
                tags="")
public class RunnerClass {

}

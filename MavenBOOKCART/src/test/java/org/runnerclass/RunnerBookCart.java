package org.runnerclass;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@Test
@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
                 glue= {"org.stepdefinitions","org.hooks"},
                 dryRun=false,monochrome=true,
                plugin= {"pretty","html:Cucumber-Report/BookCart.html","json:Cucumber-Report/BookCart.json","junit:Cucumber-Report/BookCart.xml"},
                tags="")
public class RunnerBookCart {

	
}

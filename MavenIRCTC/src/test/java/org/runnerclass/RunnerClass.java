package org.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="Features",glue= {"org.stepdefinitions","org.hooks"},
dryRun=false,monochrome=true,
plugin= {"pretty","html:Cucumber-Report/IRCTC.html","json:Cucumber-Report/IRCTC.json","junit:Cucumber-Report/IRCTC.xml"},
tags="")

public class RunnerClass {

}

package org.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="Features",glue= {"org.stepdefinitions","org.hooks"},
dryRun=false,monochrome=true,
plugin= {"pretty","html:Cucumber-Report/Admin.html","json:Cucumber-Report/Admin.json","junit:Cucumber-Report/Admin.xml"},
tags="")

public class RunnerClass {

}

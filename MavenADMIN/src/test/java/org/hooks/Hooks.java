package org.hooks;

import org.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
	//hooks is used for when feature files run each file have get this methods before and after actions
   
	@Before                                      //before action for scenario run
    public void openChrome(Scenario pass) {      //Scenario is Interface 
      //every feature file have before opened chrome browser
    	String scenarioPass = pass.getName();
    	System.out.println("Scenario Is Passed \t" +scenarioPass);
    }
    
	//TaggedHooks is used for which have this tag for scenario that only run this method before
	
	@Before("@Register")
	public void Register(Scenario scenario) {
		String register = scenario.getName();
		System.out.println("Register Details Are Entered through Data Table \t" +register);
	}
    
	
	@AfterStep                              //This hooks run after every each steps in scenarios        
	public void driverWait() throws InterruptedException {
	Thread.sleep(1500);
	}
    
    @After             
    public void close(Scenario scenario) throws InterruptedException {
    	boolean failed = scenario.isFailed();
    	System.out.println("Is Failed Scenario \t" +failed);
    	
    }
}
